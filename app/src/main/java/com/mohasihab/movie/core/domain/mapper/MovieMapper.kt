package com.mohasihab.movie.core.domain.mapper

import com.mohasihab.movie.core.data.source.remote.response.MovieDiscoverResponse
import com.mohasihab.movie.core.domain.entities.MovieDiscoverEntity
import com.mohasihab.moviejetpackcompose.BuildConfig

fun List<MovieDiscoverResponse>?.map(): List<MovieDiscoverEntity> {
    val movie: MutableList<MovieDiscoverEntity> = mutableListOf()
    this?.forEach {
        movie.add(it.map())
    }
    return movie
}

fun MovieDiscoverResponse?.map(): MovieDiscoverEntity {
    val endPointImage = BuildConfig.END_POINT_IMAGE
    val posterPath =
        if (this?.posterPath?.isNotEmpty() == true) "$endPointImage${this.posterPath}" else ""
    return MovieDiscoverEntity(
        title = this?.title ?: "",
        posterPath = posterPath,
        voteAverage = this?.voteAverage ?: 0.0,
        id = this?.id ?: 0
    )
}
