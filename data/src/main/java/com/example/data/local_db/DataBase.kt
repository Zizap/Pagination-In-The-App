package com.example.data.local_db


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.local_db.converters.GenreListConverter
import com.example.data.local_db.dao.MovieDao
import com.example.data.local_db.entities.movie.GenreEntity
import com.example.data.local_db.entities.movie.MovieEntity
import com.example.data.local_db.entities.movie.PosterEntity
import com.example.data.local_db.entities.movie.RatingEntity
import com.example.data.local_db.entities.movie.VotesEntity


@Database(
    entities = [MovieEntity::class, GenreEntity::class, PosterEntity::class, RatingEntity::class, VotesEntity::class],
    version = 1
)
@TypeConverters(value = [GenreListConverter::class])
abstract class DataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}