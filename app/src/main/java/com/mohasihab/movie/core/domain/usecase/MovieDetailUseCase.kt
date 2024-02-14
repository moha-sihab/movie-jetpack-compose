package com.mohasihab.movie.core.domain.usecase

import com.mohasihab.movie.core.data.interfaces.MovieDetailRepositoryContract
import com.mohasihab.movie.core.domain.entities.MovieDetailEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import com.mohasihab.movie.core.domain.interfaces.MovieDetailUseCaseContract
import com.mohasihab.movie.core.domain.mapper.map
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieDetailUseCase @Inject constructor(
    private val repository: MovieDetailRepositoryContract,
) : MovieDetailUseCaseContract {
    override suspend fun fetchMovieDetail(movieId: String): Flow<ResultState<MovieDetailEntity>> =
        flow {
            try {
                emit(ResultState.Loading())
                val response = repository.fetchMovieDetail(movieId)
                emit(ResultState.Success(data = response.map()))
            } catch (ex: Throwable) {
                emit(ResultState.Error(data = null, message = ex.message.toString()))
            }
        }
}