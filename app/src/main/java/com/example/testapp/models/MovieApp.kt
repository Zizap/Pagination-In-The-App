package com.example.testapp.models



data class MovieApp (
    val status: String?,
    val rating: RatingApp,
    val id: Int,
    val name: String,
    val description: String,
    val year: Int,
    val poster: PosterApp,
    val genres: List<GenreApp>,
    val votes: VotesApp
)
