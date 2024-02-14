package com.mohasihab.movie.core.domain.mapper

import com.mohasihab.movie.core.data.source.remote.response.MovieDiscoverResponse
import com.mohasihab.movie.core.domain.entities.MovieDiscoverEntity

fun List<MovieDiscoverResponse>?.map() : List<MovieDiscoverEntity> {
    val movie : MutableList<MovieDiscoverEntity> = mutableListOf()
    this?.forEach {
        movie.add(it.map())
    }
    return movie
}

fun MovieDiscoverResponse?.map(): MovieDiscoverEntity {
    return MovieDiscoverEntity(
        title = this?.title ?: "",
        posterPath = this?.posterPath ?: "",
        voteAverage = this?.voteAverage ?: 0.0,
        id = this?.id ?: 0
    )
}
