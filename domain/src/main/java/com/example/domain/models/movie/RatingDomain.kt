package com.example.domain.models.movie



data class RatingDomain(
    val id: Int,
    val kp: Double,
    val imdb: Double,
    val filmCritics: Double,
    val russianFilmCritics: Double,
    val await: String?,
)