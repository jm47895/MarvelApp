package com.jordanmadrigal.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.jordanmadrigal.marvelapp.R
import com.jordanmadrigal.marvelapp.databinding.ActivityMainBinding
import com.jordanmadrigal.marvelapp.viewmodel.ComicViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: ComicViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.syncComicData()

        setupObservers()

    }

    private fun setupObservers() {
        viewModel.getComicData().observe(this, Observer { comic ->
            comic?.let {
                Glide.with(binding.root).load("https${it.thumbnail?.path?.substring(4)}.${it.thumbnail?.extension}").into(binding.comicImageIv)
                binding.comicTitleTv.text = it.comicTitle
                binding.comicDescriptionTv.text = it.description
            }
        })
    }

    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }
}