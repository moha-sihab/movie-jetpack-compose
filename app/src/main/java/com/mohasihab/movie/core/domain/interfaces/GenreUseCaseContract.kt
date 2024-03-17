package com.mohasihab.movie.core.domain.interfaces

import com.mohasihab.movie.core.domain.entities.GenreEntity
import com.mohasihab.movie.core.domain.entities.RequestState
import com.mohasihab.movie.core.domain.entities.ResultState
import kotlinx.coroutines.flow.Flow

interface GenreUseCaseContract {
    suspend fun fetchGenre() : Flow<RequestState<GenreEntity>>
}