package com.example.testapp.models

data class RatingApp (
    val id: Int,
    val kp: Double,
    val imdb: Double,
    val filmCritics: Double,
    val russianFilmCritics: Double,
    val await: String?,
)