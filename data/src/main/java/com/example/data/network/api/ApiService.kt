package com.example.data.network.api

import com.example.data.network.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET("v1.4/movie")
    @Headers("accept: application/json")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 10,
        @Query("selectFields") selectFields: List<String> = listOf(
            "id",
            "name",
            "description",
            "status",
            "year",
            "rating",
            "genres",
            "poster",
            "votes"
        ),
        @Query("notNullFields") notNullFields: String? = null,
        @Query("genres.name") genre: String,
        @Header("X-API-KEY") apiKey: String = "6RRXT62-PDMM6WG-Q0VZ205-Z4NP8P6"
    ): MovieResponse

}