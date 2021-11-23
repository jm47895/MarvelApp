package com.jordanmadrigal.marvelapp.data.cache

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.jordanmadrigal.marvelapp.data.model.Thumbnail

class Converters {

    @TypeConverter
    fun fromThumbnailToString(thumbnail: Thumbnail): String{
        return Gson().toJson(thumbnail)
    }

    @TypeConverter
    fun fromStringToThumbnail(json: String): Thumbnail{
        return Gson().fromJson(json, Thumbnail::class.java)
    }
}