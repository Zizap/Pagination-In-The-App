package com.example.data.network.models.movie

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("name")
    val name: String?
)