package com.mohasihab.movie.core.domain.usecase

import com.mohasihab.movie.core.data.interfaces.MovieDetailRepositoryContract
import com.mohasihab.movie.core.domain.entities.MovieVideoEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import com.mohasihab.movie.core.domain.interfaces.MovieVideoUseCaseContract
import com.mohasihab.movie.core.domain.mapper.map
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieVideoUseCase @Inject constructor(
    private val repository: MovieDetailRepositoryContract,
) : MovieVideoUseCaseContract {
    override suspend fun fetchMovieVideo(movieId: String): Flow<ResultState<List<MovieVideoEntity>>> =
        flow {
            try {
                emit(ResultState.Loading())
                val response = repository.fetchMovieDetailVideos(movieId)
                emit(ResultState.Success(data = response.results.map()))
            } catch (ex: Throwable) {
                emit(ResultState.Error(data = null, message = ex.message.toString()))
            }
        }
}