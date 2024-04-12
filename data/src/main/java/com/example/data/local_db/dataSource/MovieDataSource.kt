package com.example.data.local_db.dataSource


import com.example.data.local_db.entities.movie.GenreEntity
import com.example.data.local_db.entities.movie.MovieEntity
import com.example.data.local_db.entities.movie.PosterEntity
import com.example.data.local_db.entities.movie.RatingEntity
import com.example.data.local_db.entities.movie.VotesEntity


interface MovieDataSource {

    suspend fun insertMovie(items: MovieEntity)

    suspend fun insertPoster(items: PosterEntity)

    suspend fun insertRating(items: RatingEntity)

    suspend fun insertVotes(items: VotesEntity)

    suspend fun insertGenre(items: List<GenreEntity>)

    suspend fun clear()

    fun getAllProducts(): List<MovieEntity>

}