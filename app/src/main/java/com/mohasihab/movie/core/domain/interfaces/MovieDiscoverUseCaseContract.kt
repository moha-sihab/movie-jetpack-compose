package com.mohasihab.movie.core.domain.interfaces

import com.mohasihab.movie.core.domain.entities.MovieDiscoverEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import kotlinx.coroutines.flow.Flow

interface MovieDiscoverUseCaseContract {
    suspend fun fetchMovieByGenreId(genreId : String, page : Int, previousData : List<MovieDiscoverEntity>? = null): Flow<ResultState<List<MovieDiscoverEntity>>>
}