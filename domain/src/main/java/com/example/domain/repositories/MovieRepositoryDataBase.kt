package com.example.domain.repositories

import com.example.domain.models.movie.GenreDomain
import com.example.domain.models.movie.MovieDomain
import com.example.domain.models.movie.PosterDomain
import com.example.domain.models.movie.RatingDomain
import com.example.domain.models.movie.VotesDomain

interface MovieRepositoryDataBase {

    suspend fun insertMovie(items: MovieDomain)

    suspend fun clear()

    fun getAllProducts(): List<MovieDomain>
}