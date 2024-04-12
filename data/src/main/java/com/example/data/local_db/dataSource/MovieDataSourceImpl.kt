package com.example.data.local_db.dataSource

import com.example.data.local_db.dao.MovieDao
import com.example.data.local_db.entities.movie.GenreEntity
import com.example.data.local_db.entities.movie.MovieEntity
import com.example.data.local_db.entities.movie.PosterEntity
import com.example.data.local_db.entities.movie.RatingEntity
import com.example.data.local_db.entities.movie.VotesEntity


class MovieDataSourceImpl(private val movieDao: MovieDao) : MovieDataSource {


    override suspend fun insertMovie(items: MovieEntity) {
        movieDao.insertMovie(items)
    }

    override suspend fun insertPoster(items: PosterEntity) {
        movieDao.insertPoster(items)
    }

    override suspend fun insertRating(items: RatingEntity) {
        movieDao.insertRating(items)
    }

    override suspend fun insertVotes(items: VotesEntity) {
        movieDao.insertVotes(items)
    }

    override suspend fun insertGenre(items: List<GenreEntity>) {
        movieDao.insertGenre(items)
    }

    override suspend fun clear() {
        movieDao.clear()
    }

    override fun getAllProducts(): List<MovieEntity> {
        return movieDao.getAllProducts()
    }


}