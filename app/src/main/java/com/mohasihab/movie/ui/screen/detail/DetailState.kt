package com.mohasihab.movie.ui.screen.detail

import com.mohasihab.movie.core.domain.entities.MovieDetailEntity
import com.mohasihab.movie.core.domain.entities.MovieReviewEntity
import com.mohasihab.movie.core.domain.entities.MovieVideoEntity
import com.mohasihab.movie.core.domain.entities.ResultState

data class DetailState(
    val movie: ResultState<MovieDetailEntity> = ResultState.Idle(),
    val reviews: ResultState<List<MovieReviewEntity>> = ResultState.Idle(),
    val videos: ResultState<List<MovieVideoEntity>> = ResultState.Idle(),
)
