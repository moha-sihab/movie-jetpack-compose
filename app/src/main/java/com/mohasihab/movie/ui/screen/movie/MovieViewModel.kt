package com.mohasihab.movie.ui.screen.movie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohasihab.movie.core.domain.entities.GenresItemEntity
import com.mohasihab.movie.core.domain.usecase.MovieDiscoverUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase: MovieDiscoverUseCase,
) : ViewModel() {
    var state by mutableStateOf(MovieState())
    fun fetchMovieByGenre(genre: String) {
        viewModelScope.launch {
            useCase.fetchMovieByGenreId(genre).collect {
                state = state.copy(movies = it)
            }
        }
    }

    fun setGenre(genre: GenresItemEntity) {
        state = state.copy(genre = genre)
    }
}