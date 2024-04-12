package com.example.domain.repositories

import com.example.domain.models.Either
import com.example.domain.models.ErrorResponse
import com.example.domain.models.MovieResponseDomain
import com.example.domain.models.movie.MovieDomain

interface DomainRepository {

    suspend fun loadMovie(page: Int, genre: String): Either<MovieResponseDomain, ErrorResponse>

    suspend fun loadFromDatabase(): List<MovieDomain>

}