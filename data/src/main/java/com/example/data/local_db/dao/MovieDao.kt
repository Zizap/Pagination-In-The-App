package com.example.data.local_db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.data.local_db.entities.movie.GenreEntity
import com.example.data.local_db.entities.movie.MovieEntity
import com.example.data.local_db.entities.movie.PosterEntity
import com.example.data.local_db.entities.movie.RatingEntity
import com.example.data.local_db.entities.movie.VotesEntity

@Dao
interface MovieDao {

    @Upsert
    suspend fun insertMovie(items: MovieEntity)

    @Upsert
    suspend fun insertPoster(items: PosterEntity)

    @Upsert
    suspend fun insertRating(items: RatingEntity)

    @Upsert
    suspend fun insertVotes(items: VotesEntity)

    @Upsert
    suspend fun insertGenre(items: List<GenreEntity>)

    @Query("DELETE FROM movie_data_table")
    suspend fun clear()

    @Query("SELECT * FROM movie_data_table")
    fun getAllProducts(): List<MovieEntity>

    @Query("SELECT * FROM movie_data_table WHERE name LIKE :searchName")
    fun searchCoffeeByName(searchName: String): List<MovieEntity>

}