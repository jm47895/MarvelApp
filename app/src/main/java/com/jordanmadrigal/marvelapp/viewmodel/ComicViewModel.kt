package com.jordanmadrigal.marvelapp.viewmodel

import androidx.lifecycle.ViewModel
import com.jordanmadrigal.marvelapp.repository.ComicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(
    private val comicRepository: ComicRepository
): ViewModel(){

}