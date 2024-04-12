package com.example.data.local_db.entities.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["movieId"], unique = true)])
data class GenreEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("genreId")
    val id: Int?,
    @ColumnInfo("movieId")
    val movieId: Int,
    @ColumnInfo("name")
    val name: String
)