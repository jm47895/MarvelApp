package com.jordanmadrigal.marvelapp.data.api

import com.jordanmadrigal.marvelapp.data.model.ComicResponse
import com.jordanmadrigal.marvelapp.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("v1/public/comics/67631")
    fun getComic(
        @Query("ts") timeStamp: String = Constants.timeStamp,
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("hash") hash: String = Constants.createHash()
    ): Call<ComicResponse>
}