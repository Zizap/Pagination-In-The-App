package com.example.data.local_db.entities.mappers

import com.example.data.local_db.entities.movie.GenreEntity
import com.example.data.local_db.entities.movie.MovieEntity
import com.example.data.local_db.entities.movie.PosterEntity
import com.example.data.local_db.entities.movie.RatingEntity
import com.example.data.local_db.entities.movie.VotesEntity
import com.example.domain.models.movie.MovieDomain

object MapperFromDomainToBase {
    fun mapToDbEntity(movieDomain: MovieDomain): MovieEntity {

        val genreEntityList  = movieDomain.genres.map { genre ->
            GenreEntity(
                id = genre.id,
                movieId = movieDomain.id,
                name = genre.name
            )
        }

        val movieEntity = MovieEntity(
            id = movieDomain.id,
            description = movieDomain.description,
            status = movieDomain.status,
            name = movieDomain.name,
            year = movieDomain.year,
            movieId = movieDomain.id,
            posterId = movieDomain.id,
            votesId = movieDomain.id,
            ratingId = movieDomain.id
        )

        movieEntity.genres = genreEntityList

        movieEntity.poster = PosterEntity(
            id = movieDomain.id,
            url = movieDomain.poster.url,
            previewUrl = movieDomain.poster.previewUrl
        )

        movieEntity.rating = RatingEntity(
            id = movieDomain.id,
            kp = movieDomain.rating.kp,
            imdb = movieDomain.rating.imdb,
            filmCritics = movieDomain.rating.filmCritics,
            russianFilmCritics = movieDomain.rating.russianFilmCritics,
            await = movieDomain.rating.await
        )

        movieEntity.votes = VotesEntity(
            id = movieDomain.id,
            kp = movieDomain.votes.kp,
            imdb = movieDomain.votes.imdb,
            tmdb = movieDomain.votes.tmdb,
            filmCritics = movieDomain.votes.filmCritics,
            russianFilmCritics = movieDomain.votes.russianFilmCritics,
            await = movieDomain.votes.await
        )

        return movieEntity
    }
}

fun MovieDomain.toDataEntity(): MovieEntity {
    return MapperFromDomainToBase.mapToDbEntity(this)
}