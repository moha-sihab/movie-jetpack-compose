package com.mohasihab.movie.ui.screen.movie

import com.mohasihab.movie.core.domain.entities.CardColorModel
import com.mohasihab.movie.core.domain.entities.GenresItemEntity
import com.mohasihab.movie.core.domain.entities.MovieDiscoverEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import com.mohasihab.movie.ui.theme.BlueContainer
import com.mohasihab.movie.ui.theme.OnBlueContainer

data class MovieState(
    val movies: ResultState<List<MovieDiscoverEntity>> = ResultState.Idle(),
    val genre: GenresItemEntity = GenresItemEntity(
        "", 0, CardColorModel(
            containerColor = BlueContainer,
            contentColor = OnBlueContainer
        )
    ),
)
