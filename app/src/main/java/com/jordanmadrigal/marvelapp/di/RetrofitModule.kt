package com.jordanmadrigal.marvelapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jordanmadrigal.marvelapp.data.api.MarvelService
import com.jordanmadrigal.marvelapp.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideMarvelService(retrofit: Retrofit.Builder): MarvelService {
        return retrofit.build().create(MarvelService::class.java)
    }
}