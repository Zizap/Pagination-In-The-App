package com.example.domain.models.movie


data class VotesDomain(
    val id: Int,
    val kp: Int,
    val imdb: Int,
    val tmdb: Int,
    val filmCritics: Int,
    val russianFilmCritics: Int,
    val await: Int
)