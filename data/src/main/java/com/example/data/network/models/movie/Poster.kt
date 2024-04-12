package com.example.data.network.models.movie

import com.google.gson.annotations.SerializedName

data class Poster(
    @SerializedName("url")
    val url: String?,
    @SerializedName("previewUrl")
    val previewUrl: String?
)