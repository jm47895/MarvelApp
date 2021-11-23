package com.jordanmadrigal.marvelapp.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jordanmadrigal.marvelapp.data.model.Comic

@Database(entities = [Comic::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ComicDatabase: RoomDatabase(){
    abstract fun getComicDao(): ComicDao
}