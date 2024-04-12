package com.example.testapp.models.mapper

import com.example.domain.models.movie.MovieDomain
import com.example.testapp.models.GenreApp
import com.example.testapp.models.MovieApp
import com.example.testapp.models.PosterApp
import com.example.testapp.models.RatingApp
import com.example.testapp.models.VotesApp

object DomainMapperToApp {
    fun mapToApp(movieDomain: MovieDomain): MovieApp {
        val genreAppList: List<GenreApp> = movieDomain.genres.map { genre ->
            GenreApp(
                movieId = genre.movieId,
                id = genre.id ?: 0,
                name = genre.name
            )
        }

        return MovieApp(
            id = movieDomain.id,
            description = movieDomain.description,
            status = movieDomain.status,
            rating = RatingApp(
                id = movieDomain.rating.id,
                kp = movieDomain.rating.kp,
                imdb = movieDomain.rating.imdb,
                filmCritics = movieDomain.rating.filmCritics,
                russianFilmCritics = movieDomain.rating.russianFilmCritics,
                await = movieDomain.rating.await
            ),
            name = movieDomain.name,
            year = movieDomain.year,
            poster = PosterApp(
                id = movieDomain.poster.id,
                url = movieDomain.poster.url,
                previewUrl = movieDomain.poster.previewUrl
            ),
            genres = genreAppList,
            votes = VotesApp(
                id = movieDomain.votes.id,
                kp = movieDomain.votes.kp,
                imdb = movieDomain.votes.imdb,
                tmdb = movieDomain.votes.tmdb,
                filmCritics = movieDomain.votes.filmCritics,
                russianFilmCritics = movieDomain.votes.russianFilmCritics,
                await = movieDomain.votes.await
            )
        )
    }
}

fun MovieDomain.toDomainApp(): MovieApp {
    return DomainMapperToApp.mapToApp(this)
}