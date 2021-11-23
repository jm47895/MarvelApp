package com.jordanmadrigal.marvelapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicResponse(
    @SerializedName("copyright")
    @Expose
    var copyright: String?,

    @SerializedName("data")
    @Expose
    var data: Data?
)