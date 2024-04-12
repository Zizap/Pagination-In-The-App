package com.example.data.network.apiDataSource

import com.example.domain.models.Either
import com.example.data.network.api.ApiClient
import com.example.domain.models.ErrorResponse
import com.example.data.network.models.MovieResponse

const val MAX_PAGE_SIZE: Int = 20

class MovieApiDataSourceImpl() : MovieApiDataSource {


    override suspend fun loadMovies(
        page: Int,
        genre: String
    ): Either<MovieResponse, ErrorResponse> {

        lateinit var either: Either<MovieResponse, ErrorResponse>

        val call = ApiClient.instanse?.api?.getMovies(page = page, genre = genre)

        either = try {
            Either.Success(call!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Failure(ErrorResponse(e))
        }
        return either
    }

}

