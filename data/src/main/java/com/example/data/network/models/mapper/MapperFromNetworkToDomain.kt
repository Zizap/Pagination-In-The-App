package com.example.data.network.models.mapper

import com.example.data.network.models.movie.Movie
import com.example.domain.models.movie.GenreDomain
import com.example.domain.models.movie.MovieDomain
import com.example.domain.models.movie.PosterDomain
import com.example.domain.models.movie.RatingDomain
import com.example.domain.models.movie.VotesDomain

object MapperFromNetworkToDomain {
    fun mapToDomainForNetwork(movie: Movie): MovieDomain {
        val genreDomainList: List<GenreDomain>? = movie.genres?.map { genre ->
            GenreDomain(
                movieId = movie.id,
                id = genre.id,
                name = genre.name
            )
        }
        return MovieDomain(
            id = movie.id,
            description = movie.description ?: "",
            status = movie.status,
            rating = RatingDomain(
                id = movie.id,
                kp = movie.rating?.kp ?: 0.0,
                imdb = movie.rating?.imdb ?: 0.0,
                filmCritics = movie.rating?.filmCritics ?: 0.0,
                russianFilmCritics = movie.rating?.russianFilmCritics ?: 0.0,
                await = movie.rating?.await
            ),
            name = movie.name ?: "",
            year = movie.year ?: 2000,
            poster = PosterDomain(
                id = movie.id,
                url = movie.poster?.url ?: "",
                previewUrl = movie.poster?.previewUrl ?: ""
            ),
            genres = genreDomainList ?: emptyList(),
            votes = VotesDomain(
                id = movie.id,
                kp = movie.votes?.kp ?: 0,
                imdb = movie.votes?.imdb ?: 0,
                tmdb = movie.votes?.tmdb  ?: 0,
                filmCritics = movie.votes?.filmCritics ?: 0,
                russianFilmCritics = movie.votes?.russianFilmCritics ?: 0,
                await = movie.votes?.await ?: 0
            )
        )
    }
}
fun Movie.toDomainEntity(): MovieDomain {
    return MapperFromNetworkToDomain.mapToDomainForNetwork(this)
}