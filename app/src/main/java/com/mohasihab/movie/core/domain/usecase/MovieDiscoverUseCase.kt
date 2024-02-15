package com.mohasihab.movie.core.domain.usecase

import com.mohasihab.movie.core.data.interfaces.MovieDiscoverRepositoryContract
import com.mohasihab.movie.core.domain.entities.MovieDiscoverEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import com.mohasihab.movie.core.domain.interfaces.MovieDiscoverUseCaseContract
import com.mohasihab.movie.core.domain.mapper.map
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieDiscoverUseCase @Inject constructor(
    private val repository: MovieDiscoverRepositoryContract,
) : MovieDiscoverUseCaseContract {
    override suspend fun fetchMovieByGenreId(
        genreId: String,
        page: Int,
        previousData: List<MovieDiscoverEntity>?,
    ): Flow<ResultState<List<MovieDiscoverEntity>>> =
        flow {
            try {
                emit(ResultState.Loading())
                val params = hashMapOf(
                    "with_genres" to genreId,
                    "page" to page.toString()
                )

                val response = repository.fetchDiscoverMovieByGenre(params)
                val dataMovies: MutableList<MovieDiscoverEntity> = mutableListOf()
                if (page > 1) {
                    if (previousData != null) {
                        dataMovies.addAll(previousData)
                        dataMovies.addAll(response.results.map())
                    }
                } else {
                    dataMovies.addAll(response.results.map())
                }
                emit(ResultState.Success(data = dataMovies))
            } catch (ex: Throwable) {
                emit(ResultState.Error(data = null, message = ex.message.toString()))
            }
        }
}
