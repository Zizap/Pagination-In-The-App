package com.example.data.local_db.entities.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["votesId"], unique = true)])
data class VotesEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("votesId")
    val id: Int,
    @ColumnInfo("kp")
    val kp: Int,
    @ColumnInfo("imdb")
    val imdb: Int,
    @ColumnInfo("tmdb")
    val tmdb: Int,
    @ColumnInfo("filmCritics")
    val filmCritics: Int,
    @ColumnInfo("russianFilmCritics")
    val russianFilmCritics: Int,
    @ColumnInfo("await")
    val await: Int
)