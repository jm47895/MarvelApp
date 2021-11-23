package com.jordanmadrigal.marvelapp.di

import android.content.Context
import androidx.room.Room
import com.jordanmadrigal.marvelapp.data.cache.ComicDao
import com.jordanmadrigal.marvelapp.data.cache.ComicDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ComicDatabase {
        return Room.databaseBuilder(
            appContext,
            ComicDatabase::class.java,
            "comics.db"
        ).build()
    }

    @Provides
    fun provideComicDao(database: ComicDatabase) : ComicDao {
        return database.getComicDao()
    }
}