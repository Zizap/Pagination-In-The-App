package com.example.data.repositories

import android.util.Log
import com.example.data.local_db.dataSource.MovieDataSource
import com.example.data.local_db.entities.mappers.MapperFromBaseToDomain
import com.example.data.local_db.entities.mappers.toDataEntity

import com.example.domain.models.movie.MovieDomain
import com.example.domain.repositories.MovieRepositoryDataBase

class MovieRepositoryDataBaseImpl(
    private val movieDataSource: MovieDataSource
) : MovieRepositoryDataBase {

    //DataBase
    override suspend fun insertMovie(items: MovieDomain) {
        val movie = items.toDataEntity()
        movieDataSource.clear()
        movieDataSource.insertPoster(movie.poster)
        movieDataSource.insertRating(movie.rating)
        movieDataSource.insertGenre(movie.genres)
        movieDataSource.insertVotes(movie.votes)
        movieDataSource.insertMovie(movie)
    }

    override suspend fun clear() {
        movieDataSource.clear()
    }

    override fun getAllProducts(): List<MovieDomain> {
        val movieEntities = movieDataSource.getAllProducts()
        return movieEntities.map { entity -> MapperFromBaseToDomain.mapFromDbEntity(entity) }
    }
}