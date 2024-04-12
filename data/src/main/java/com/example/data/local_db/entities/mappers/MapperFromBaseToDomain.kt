package com.example.data.local_db.entities.mappers

import com.example.data.local_db.entities.movie.MovieEntity
import com.example.domain.models.movie.GenreDomain
import com.example.domain.models.movie.MovieDomain
import com.example.domain.models.movie.PosterDomain
import com.example.domain.models.movie.RatingDomain
import com.example.domain.models.movie.VotesDomain

object MapperFromBaseToDomain {
    fun mapFromDbEntity(dbEntity: MovieEntity): MovieDomain {

        val genreDomainList: List<GenreDomain> = dbEntity.genres.map { genre ->
            GenreDomain(
                movieId = dbEntity.id,
                id = genre.id,
                name = genre.name
            )
        }

        return MovieDomain(
            id = dbEntity.id,
            description = dbEntity.description,
            status = dbEntity.status,
            rating = RatingDomain(
                id = dbEntity.id,
                kp = dbEntity.rating.kp,
                imdb = dbEntity.rating.imdb,
                filmCritics = dbEntity.rating.filmCritics,
                russianFilmCritics = dbEntity.rating.russianFilmCritics,
                await = null
            ),
            name = dbEntity.name,
            year = dbEntity.year,
            poster = PosterDomain(
                id = dbEntity.id,
                url = dbEntity.poster.url,
                previewUrl = dbEntity.poster.previewUrl
            ),
            genres = genreDomainList,
            votes = VotesDomain(
                id = dbEntity.id,
                kp = dbEntity.votes.kp,
                imdb = dbEntity.votes.imdb,
                tmdb = dbEntity.votes.tmdb,
                filmCritics = dbEntity.votes.filmCritics,
                russianFilmCritics = dbEntity.votes.russianFilmCritics,
                await = dbEntity.votes.await
            )


        )
    }
}

fun MovieEntity.toDomainEntity(): MovieDomain {
    return MapperFromBaseToDomain.mapFromDbEntity(this)
}