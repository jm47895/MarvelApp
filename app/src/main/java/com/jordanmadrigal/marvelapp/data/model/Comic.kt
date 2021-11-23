package com.jordanmadrigal.marvelapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "comic_table")
data class Comic(

    @SerializedName("id")
    @Expose
    @PrimaryKey @ColumnInfo(name = "comic_id")
    var id: Int,

    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "comic_title")
    var comicTitle: String?,

    @SerializedName("description")
    @Expose
    @ColumnInfo(name = "comic_description")
    var description: String?,

    @SerializedName("thumbnail")
    @Expose
    @ColumnInfo(name = "thumbnail_url")
    var thumbnail: Thumbnail?
) {

}