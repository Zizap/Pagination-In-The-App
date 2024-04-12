package com.example.domain.models.movie

data class MovieDomain(
    val status: String?,
    val rating: RatingDomain,
    val id: Int,
    val name: String,
    val description: String,
    val year: Int,
    val poster: PosterDomain,
    val genres: List<GenreDomain>,
    val votes: VotesDomain
)







