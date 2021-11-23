package com.jordanmadrigal.marvelapp.repository

import android.util.Log
import com.jordanmadrigal.marvelapp.data.api.MarvelService
import com.jordanmadrigal.marvelapp.data.cache.ComicDatabase
import com.jordanmadrigal.marvelapp.data.model.Comic
import com.jordanmadrigal.marvelapp.data.model.Thumbnail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.awaitResponse
import java.lang.Exception
import javax.inject.Inject

class ComicRepository @Inject constructor(
    private val cacheDb:ComicDatabase,
    private val marvelService: MarvelService
) {
    suspend fun insertComicIntoCacheDb(comic: Comic){
        cacheDb.getComicDao().insertComic(comic)
    }

    fun getComicInCache(id: String): Flow<Comic> {
        return cacheDb.getComicDao().getComic(id)
    }

    fun getComic() =  flow {
        try {
            val response = marvelService.getComic().awaitResponse()

            if(response.isSuccessful){
                val comicId = response.body()?.data?.results?.get(0)?.id
                val comicTitle = response.body()?.data?.results?.get(0)?.comicTitle
                val comicDescription = response.body()?.data?.results?.get(0)?.description
                val comicThumbnail = Thumbnail(response.body()?.data?.results?.get(0)?.thumbnail?.path, response.body()?.data?.results?.get(0)?.thumbnail?.extension)
                val comic = Comic(comicId!!, comicTitle, comicDescription, comicThumbnail)
                emit(comic)
            }else{
                Log.e(TAG, response.code().toString())
            }
        }catch (e: Exception){
            Log.e(TAG, "Marvel database not reached.")
        }
    }.flowOn(Dispatchers.IO)

    companion object{
        private val TAG = ComicRepository::class.java.simpleName
    }

}