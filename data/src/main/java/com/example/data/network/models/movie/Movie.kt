package com.example.data.network.models.movie


import com.example.domain.models.movie.GenreDomain
import com.example.domain.models.movie.PosterDomain
import com.example.domain.models.movie.RatingDomain
import com.example.domain.models.movie.VotesDomain
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("status")
    val status: String?,
    @SerializedName("rating")
    val rating: RatingDomain?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("year")
    val year: Int?,
    @SerializedName("poster")
    val poster: PosterDomain?,
    @SerializedName("genres")
    val genres: List<GenreDomain>?,
    @SerializedName("votes")
    val votes: VotesDomain?
)









