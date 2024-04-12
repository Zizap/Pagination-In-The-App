package com.example.domain.repositories

import com.example.domain.models.Either
import com.example.domain.models.ErrorResponse
import com.example.domain.models.MovieResponseDomain



interface MovieRepositoryNetwork {

    suspend fun getMovie(page: Int, genre: String): Either<MovieResponseDomain, ErrorResponse>

//    class Network(private val movieApiDataSource: MovieApiDataSource) : MovieRepository {
//
//        override suspend fun getMovie(page: Int, genre: String): Either<MovieResponse, ErrorResponse> {
//            return movieApiDataSource.getMovies(page = page, genre = genre)
//        }
//
//    }

}