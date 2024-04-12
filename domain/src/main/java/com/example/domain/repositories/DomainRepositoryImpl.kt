package com.example.domain.repositories

import android.util.Log
import com.example.domain.models.Either
import com.example.domain.models.ErrorResponse
import com.example.domain.models.MovieResponseDomain
import com.example.domain.models.movie.MovieDomain

class DomainRepositoryImpl(
    private val movieRepositoryDataBase: MovieRepositoryDataBase,
    private val movieRepositoryNetwork: MovieRepositoryNetwork
) : DomainRepository {

    override suspend fun loadMovie(
        page: Int,
        genre: String
    ): Either<MovieResponseDomain, ErrorResponse> {

        return when (val either = movieRepositoryNetwork.getMovie(genre = genre, page = page)) {
            is Either.Success -> {
                either.value.movies.forEach { movieDomain ->
                    movieRepositoryDataBase.insertMovie(movieDomain)
                }
                either
            }

            is Either.Failure -> {
                either
            }
        }
    }

    override suspend fun loadFromDatabase(): List<MovieDomain> {
        return movieRepositoryDataBase.getAllProducts()
    }
}