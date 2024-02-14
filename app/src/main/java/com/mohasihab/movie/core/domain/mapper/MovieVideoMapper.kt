package com.mohasihab.movie.core.domain.mapper

import com.mohasihab.movie.core.data.source.remote.response.MovieVideoResponse
import com.mohasihab.movie.core.domain.entities.MovieVideoEntity

fun List<MovieVideoResponse>?.map() : List<MovieVideoEntity> {
    val movie : MutableList<MovieVideoEntity> = mutableListOf()
    this?.forEach {
        movie.add(it.map())
    }
    return movie
}

fun MovieVideoResponse?.map(): MovieVideoEntity {
    return MovieVideoEntity(
        site = this?.site ?: "",
        size = this?.size ?: 0,
        name = this?.name ?: "",
        official = this?.official ?: false,
        id = this?.id ?: "",
        type = this?.type ?: "",
        publishedAt = this?.publishedAt ?: "",
        key = this?.key ?: ""
    )
}