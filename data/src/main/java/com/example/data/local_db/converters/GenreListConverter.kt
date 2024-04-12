package com.example.data.local_db.converters

import androidx.room.TypeConverter
import com.example.data.local_db.entities.movie.GenreEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreListConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String): List<GenreEntity> {
        val listType = object : TypeToken<List<GenreEntity>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<GenreEntity>): String {
        return gson.toJson(list)
    }
}