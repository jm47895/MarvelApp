package com.jordanmadrigal.marvelapp.repository

import com.jordanmadrigal.marvelapp.data.cache.ComicDatabase
import javax.inject.Inject

class ComicRepository @Inject constructor(
    private val cacheDb: ComicDatabase
) {
    /*suspend fun insertComicIntoCacheDb(comic: Comic){
        cacheDb.getComicDao().insertComic(comic)
    }

    fun getComicInCache(id: String): Flow<Comic> {
        return cacheDb.getComicDao().getComic(id)
    }*/
}