package com.mohasihab.movie.ui.screen.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohasihab.movie.core.domain.interfaces.MovieDetailUseCaseContract
import com.mohasihab.movie.core.domain.interfaces.MovieReviewUseCaseContract
import com.mohasihab.movie.core.domain.interfaces.MovieVideoUseCaseContract
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCaseMovie: MovieDetailUseCaseContract,
    private val useCaseReview: MovieReviewUseCaseContract,
    private val useCaseVideo: MovieVideoUseCaseContract,
) : ViewModel() {
    var state by mutableStateOf(DetailState())

    fun fetchDetailMovie(movieId: String) {
        viewModelScope.launch {
            combine(
                useCaseMovie.fetchMovieDetail(movieId),
                useCaseReview.fetchMovieReview(movieId),
                useCaseVideo.fetchMovieVideo(movieId)
            ) { first, second, third ->
                Triple(first, second, third)
            }.collect {
                state = state.copy(
                    movie = it.first,
                    reviews = it.second,
                    videos = it.third
                )
            }
        }
    }

}