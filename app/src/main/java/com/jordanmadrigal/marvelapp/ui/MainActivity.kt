package com.jordanmadrigal.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.jordanmadrigal.marvelapp.R
import com.jordanmadrigal.marvelapp.databinding.ActivityMainBinding
import com.jordanmadrigal.marvelapp.repository.ComicRepository.Companion.FAILURE
import com.jordanmadrigal.marvelapp.repository.ComicRepository.Companion.LOADING
import com.jordanmadrigal.marvelapp.repository.ComicRepository.Companion.NO_INTERNET
import com.jordanmadrigal.marvelapp.repository.ComicRepository.Companion.SUCCESS
import com.jordanmadrigal.marvelapp.util.AndroidUtils
import com.jordanmadrigal.marvelapp.viewmodel.ComicViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private val viewModel: ComicViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private var isSyncTriggered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.syncComicData()

        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {
        binding.syncButton.setOnClickListener {
            viewModel.syncComicData()
            isSyncTriggered = true
        }
    }

    private fun setupObservers() {

        viewModel.getComicData().observe(this, Observer { comic ->
            comic?.let {
                Glide.with(binding.root).load("https${it.thumbnail?.path?.substring(4)}.${it.thumbnail?.extension}").into(binding.comicImageIv)
                binding.comicTitleTv.text = it.comicTitle
                binding.comicDescriptionTv.text = it.description
            }
        })

        viewModel.getApiStatus().observe(this, Observer { status ->
            when(status){
                SUCCESS -> {
                    if(isSyncTriggered){
                        AndroidUtils.showSnackBar(this, getString(R.string.data_synced))
                        isSyncTriggered = false
                    }
                    displayProgressBar(false)
                }
                LOADING -> displayProgressBar(true)
                NO_INTERNET ->{
                    displayProgressBar(false)
                    AndroidUtils.showSnackBar(this, getString(R.string.offline_msg))
                }
                FAILURE -> {
                    displayProgressBar(false)
                    AndroidUtils.showSnackBar(this, getString(R.string.db_error_msg))
                }
            }
        })
    }

    private fun displayProgressBar(isVisible: Boolean){
        if(isVisible) binding.progressBar.visibility = View.VISIBLE else binding.progressBar.visibility = View.INVISIBLE
    }

    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }
}