package com.jordanmadrigal.marvelapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comic_table")
data class Comic(

    @PrimaryKey @ColumnInfo(name = "comic_id")
    var id: String,

    @ColumnInfo(name = "comic_title")
    var comicTitle: String,

    @ColumnInfo(name = "comic_description")
    var description: String,

    @ColumnInfo(name = "img_url")
    var coverImgUrl: String
) {
}