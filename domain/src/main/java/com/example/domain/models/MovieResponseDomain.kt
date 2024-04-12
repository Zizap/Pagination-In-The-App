package com.example.domain.models

import com.example.domain.models.movie.MovieDomain

data class MovieResponseDomain (
    val movies: List<MovieDomain>
)
