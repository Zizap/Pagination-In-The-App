package com.example.domain.di

import com.example.domain.repositories.DomainRepository
import com.example.domain.repositories.DomainRepositoryImpl
import com.example.domain.repositories.MovieRepositoryNetwork
import com.example.domain.usecase.GetDataUseCase
import org.koin.dsl.module


val domainModule = module {

    single { GetDataUseCase(get()) }

    single<DomainRepository> { DomainRepositoryImpl(get(), get()) }

}