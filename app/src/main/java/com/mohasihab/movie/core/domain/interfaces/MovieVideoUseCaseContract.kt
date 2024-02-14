package com.mohasihab.movie.core.domain.interfaces

import com.mohasihab.movie.core.domain.entities.MovieVideoEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import kotlinx.coroutines.flow.Flow

interface MovieVideoUseCaseContract {
    suspend fun fetchMovieVideo(movieId: String): Flow<ResultState<List<MovieVideoEntity>>>
}