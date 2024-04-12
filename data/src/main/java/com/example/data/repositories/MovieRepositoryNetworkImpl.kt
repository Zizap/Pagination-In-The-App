package com.example.data.repositories

import com.example.data.network.apiDataSource.MovieApiDataSource
import com.example.data.network.models.mapper.MapperFromNetworkToDomain
import com.example.domain.models.Either
import com.example.domain.models.ErrorResponse
import com.example.domain.models.MovieResponseDomain
import com.example.domain.repositories.MovieRepositoryNetwork

class MovieRepositoryNetworkImpl(
    private val movieApiDataSource: MovieApiDataSource
) : MovieRepositoryNetwork {

    //Network
    override suspend fun getMovie(
        page: Int,
        genre: String
    ): Either<MovieResponseDomain, ErrorResponse> {

        return try {
            when (val result = movieApiDataSource.loadMovies(genre = genre, page = page)) {
                is Either.Success -> {
                    val moviesList = result.value.movies.map { movie ->
                        MapperFromNetworkToDomain.mapToDomainForNetwork(movie)
                    }
                    Either.Success(MovieResponseDomain(moviesList))
                }
                is Either.Failure -> {
                    Either.Failure(ErrorResponse(result.error.error ?: Exception()))
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Failure(ErrorResponse(e))
        }
    }
}