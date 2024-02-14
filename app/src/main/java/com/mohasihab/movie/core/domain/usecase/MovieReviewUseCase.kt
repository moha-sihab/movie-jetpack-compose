package com.mohasihab.movie.core.domain.usecase

import com.mohasihab.movie.core.data.interfaces.MovieDetailRepositoryContract
import com.mohasihab.movie.core.domain.entities.MovieReviewEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import com.mohasihab.movie.core.domain.interfaces.MovieReviewUseCaseContract
import com.mohasihab.movie.core.domain.mapper.map
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieReviewUseCase @Inject constructor(
    private val repository: MovieDetailRepositoryContract,
) : MovieReviewUseCaseContract {
    override suspend fun fetchMovieReview(movieId: String): Flow<ResultState<List<MovieReviewEntity>>> =
        flow {
            try {
                emit(ResultState.Loading())
                val params = hashMapOf(
                    "page" to "1"
                )
                val response = repository.fetchMovieDetailReviews(movieId, params)
                emit(ResultState.Success(data = response.results.map()))
            } catch (ex: Throwable) {
                emit(ResultState.Error(data = null, message = ex.message.toString()))
            }
        }
}