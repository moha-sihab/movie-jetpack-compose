package com.mohasihab.movie.ui.screen.home

import com.mohasihab.movie.core.domain.entities.GenreEntity
import com.mohasihab.movie.core.domain.entities.ResultState

data class HomeState(
    val genre: ResultState<GenreEntity> = ResultState.Loading(),
)
