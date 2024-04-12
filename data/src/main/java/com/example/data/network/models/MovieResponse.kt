package com.example.data.network.models

import com.example.data.network.models.movie.Movie
import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("docs")
    val movies: List<Movie>
)