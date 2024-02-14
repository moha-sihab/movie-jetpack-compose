package com.mohasihab.movie.core.domain.interfaces

import com.mohasihab.movie.core.domain.entities.MovieDetailEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import kotlinx.coroutines.flow.Flow

interface MovieDetailUseCaseContract {
    suspend fun fetchMovieDetail(movieId : String) : Flow<ResultState<MovieDetailEntity>>
}