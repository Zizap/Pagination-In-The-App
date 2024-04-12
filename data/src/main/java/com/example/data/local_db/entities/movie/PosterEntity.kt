package com.example.data.local_db.entities.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(indices = [Index(value = ["posterId"], unique = true)])
data class PosterEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("posterId")
    val id: Int,
    @ColumnInfo("url")
    val url: String,
    @ColumnInfo("previewUrl")
    val previewUrl: String
)