package com.mohasihab.movie.core.domain.usecase

import com.mohasihab.movie.core.data.interfaces.GenreRepositoryContract
import com.mohasihab.movie.core.domain.entities.GenreEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import com.mohasihab.movie.core.domain.interfaces.GenreUseCaseContract
import com.mohasihab.movie.core.domain.mapper.map
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GenreUseCase @Inject constructor(
    private val repository: GenreRepositoryContract,
) : GenreUseCaseContract {
    override suspend fun fetchGenre(): Flow<ResultState<GenreEntity>> = flow {
        try {
            emit(ResultState.Loading())
            val response = repository.fetchGenres()
            emit(ResultState.Success(data = response.map()))
        } catch (ex: Throwable) {
            emit(ResultState.Error(message = ex.message.toString(), data = null))
        }
    }
}