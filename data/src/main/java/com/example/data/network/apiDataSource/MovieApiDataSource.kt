package com.example.data.network.apiDataSource

import com.example.domain.models.Either
import com.example.domain.models.ErrorResponse
import com.example.data.network.models.MovieResponse

interface MovieApiDataSource {

    suspend fun loadMovies(page: Int, genre: String): Either<MovieResponse, ErrorResponse>
}