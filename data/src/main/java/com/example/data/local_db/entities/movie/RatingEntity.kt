package com.example.data.local_db.entities.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(indices = [Index(value = ["ratingId"], unique = true)])
data class RatingEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("ratingId")
    val id: Int,
    @ColumnInfo("kp")
    val kp: Double,
    @ColumnInfo("imdb")
    val imdb: Double,
    @ColumnInfo("filmCritics")
    val filmCritics: Double,
    @ColumnInfo("russianFilmCritics")
    val russianFilmCritics: Double,
    @ColumnInfo("await")
    val await: String?,
)