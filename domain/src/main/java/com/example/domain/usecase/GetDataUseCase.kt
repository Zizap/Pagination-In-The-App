package com.example.domain.usecase


import com.example.domain.models.Either
import com.example.domain.models.ErrorResponse
import com.example.domain.models.MovieResponseDomain
import com.example.domain.models.movie.MovieDomain
import com.example.domain.repositories.DomainRepository

class GetDataUseCase(
    private val domainRepository: DomainRepository,
) {

    suspend fun loadMovie(page: Int, genre: String): Either<MovieResponseDomain, ErrorResponse>{
        return domainRepository.loadMovie(page = page, genre = genre)
    }

    suspend fun loadFromDatabase(): List<MovieDomain> {
        return domainRepository.loadFromDatabase()
    }

}