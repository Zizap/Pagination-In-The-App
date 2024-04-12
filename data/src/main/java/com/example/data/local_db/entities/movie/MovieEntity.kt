package com.example.data.local_db.entities.movie

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.data.local_db.converters.GenreListConverter

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = RatingEntity::class,
            parentColumns = ["ratingId"],
            childColumns = ["ratingId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = PosterEntity::class,
            parentColumns = ["posterId"],
            childColumns = ["posterId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = VotesEntity::class,
            parentColumns = ["votesId"],
            childColumns = ["votesId"],
            onDelete = ForeignKey.CASCADE
        )
        ,
        ForeignKey(
            entity = GenreEntity::class,
            parentColumns = ["movieId"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    tableName = "movie_data_table"
)

data class MovieEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("status")
    val status: String?,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("year")
    val year: Int,

    @ColumnInfo("posterId")
    val posterId: Int,
    @ColumnInfo("votesId")
    val votesId: Int,
    @ColumnInfo("movieId")
    val movieId: Int,
    @ColumnInfo("ratingId")
    val ratingId: Int,


) {

    @Embedded(prefix = "rating_")
    lateinit var rating: RatingEntity

    @Embedded(prefix = "poster_")
    lateinit var poster: PosterEntity

    @Embedded(prefix = "votes_")
    lateinit var votes: VotesEntity

    @TypeConverters(GenreListConverter::class)
    lateinit var genres: List<GenreEntity>
}




