package com.jordanmadrigal.marvelapp.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jordanmadrigal.marvelapp.data.Comic

@Database(entities = [Comic::class], version = 1, exportSchema = false)
abstract class ComicDatabase: RoomDatabase(){
    abstract fun getComicDao(): ComicDao
}