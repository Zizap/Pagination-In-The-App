package com.example.testapp.screens.mainScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Either
import com.example.domain.usecase.GetDataUseCase
import com.example.testapp.R
import com.example.testapp.models.MovieApp
import com.example.testapp.models.mapper.DomainMapperToApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class MainScreenVM(private val getDataUseCase: GetDataUseCase) : ViewModel() {

    init {
        getMovies2(INIT_GENRE)
    }

    private val _mainScreenUiState = MutableStateFlow(
        MainScreenUiState(
            movies = emptyList(),
            posters = listOf(
                R.drawable.image1,
                R.drawable.image1,
                R.drawable.image1,
                R.drawable.image1,
                R.drawable.image1
            ),
            tags = tagList
        )
    )

    val mainScreenUiState: StateFlow<MainScreenUiState> = _mainScreenUiState

    fun getMovies2(genres: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val either = getDataUseCase.loadMovie(genre = genres, page = 1)) {
                is Either.Success -> {
                    _mainScreenUiState.update {
                        it.copy(
                            movies = either.value.movies.map { movieDomain ->
                                DomainMapperToApp.mapToApp(movieDomain)
                            },
                            error = null
                        )
                    }
                }

                is Either.Failure -> {
                    if (either.error.error is UnknownHostException) {
                        _mainScreenUiState.update {
                            it.copy(
                                error = "Нет интернета",
                                movies = getDataUseCase.loadFromDatabase().map { movieDomain ->
                                    DomainMapperToApp.mapToApp(movieDomain)
                                }
                            )
                        }
                    } else {
                        _mainScreenUiState.update {
                            it.copy(
                                error = "Неизвестная ошибка",
                                movies = getDataUseCase.loadFromDatabase().map { movieDomain ->
                                    DomainMapperToApp.mapToApp(movieDomain)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
    companion object {
        const val INIT_GENRE = "боевик"
    }
}

data class MainScreenUiState(
    val posters: List<Int>,
    val tags: List<String>,
    val movies: List<MovieApp>,
    val error: String? = null
)
