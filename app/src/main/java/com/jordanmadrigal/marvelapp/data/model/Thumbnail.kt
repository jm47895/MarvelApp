package com.jordanmadrigal.marvelapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("path")
    @Expose
    var path: String?,
    @SerializedName("extension")
    @Expose
    var extension: String?
)