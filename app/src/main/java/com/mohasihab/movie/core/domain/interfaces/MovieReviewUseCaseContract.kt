package com.mohasihab.movie.core.domain.interfaces

import com.mohasihab.movie.core.domain.entities.MovieReviewEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import kotlinx.coroutines.flow.Flow

interface MovieReviewUseCaseContract {
    suspend fun fetchMovieReview(movieId: String): Flow<ResultState<List<MovieReviewEntity>>>
}
