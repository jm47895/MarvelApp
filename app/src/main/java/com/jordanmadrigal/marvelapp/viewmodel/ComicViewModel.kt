package com.jordanmadrigal.marvelapp.viewmodel

import androidx.lifecycle.*
import com.jordanmadrigal.marvelapp.data.model.Comic
import com.jordanmadrigal.marvelapp.repository.ComicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(
    private val comicRepository: ComicRepository
): ViewModel(){

    fun syncComicData(){
        viewModelScope.launch {
            comicRepository.getComic().collect {
                comicRepository.insertComicIntoCacheDb(it)
            }
        }
    }

    fun getComicData(): LiveData<Comic> {
        return comicRepository.getComicInCache(67631).asLiveData()
    }

    fun getApiStatus(): MutableLiveData<Int> {
        return  comicRepository.getApiStatus()
    }
}