package com.example.data.di


import androidx.room.Room
import com.example.data.local_db.DataBase
import com.example.data.local_db.dataSource.MovieDataSource
import com.example.data.local_db.dataSource.MovieDataSourceImpl
import com.example.data.network.apiDataSource.MovieApiDataSource
import com.example.data.network.apiDataSource.MovieApiDataSourceImpl
import com.example.data.repositories.MovieRepositoryDataBaseImpl
import com.example.data.repositories.MovieRepositoryNetworkImpl
import com.example.domain.repositories.MovieRepositoryDataBase
import com.example.domain.repositories.MovieRepositoryNetwork
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single {
        Room.databaseBuilder(
            androidContext(), DataBase::class.java,
            "Db"
        ).fallbackToDestructiveMigration().build()
    }

    single { get<DataBase>().movieDao() }

    single<MovieDataSource> { MovieDataSourceImpl(get()) }

    single<MovieApiDataSource> { MovieApiDataSourceImpl() }

    single<MovieRepositoryDataBase> { MovieRepositoryDataBaseImpl(get()) }

    single<MovieRepositoryNetwork> { MovieRepositoryNetworkImpl(get()) }

}

