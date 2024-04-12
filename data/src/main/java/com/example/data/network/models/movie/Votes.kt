package com.example.data.network.models.movie

import com.google.gson.annotations.SerializedName

data class Votes(
    @SerializedName("kp")
    val kp: Int,
    @SerializedName("imdb")
    val imdb: Int,
    @SerializedName("tmdb")
    val tmdb: Int?,
    @SerializedName("filmCritics")
    val filmCritics: Int?,
    @SerializedName("russianFilmCritics")
    val russianFilmCritics: Int?,
    @SerializedName("await")
    val await: Int?
)