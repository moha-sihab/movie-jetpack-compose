package com.mohasihab.movie.core.domain.mapper

import com.mohasihab.movie.core.data.source.remote.response.GenreResponse
import com.mohasihab.movie.core.data.source.remote.response.GenresItemResponse
import com.mohasihab.movie.core.domain.entities.GenreEntity
import com.mohasihab.movie.core.domain.entities.GenresItemEntity

fun List<GenreResponse>.map() : List<GenreEntity> {
    val genres : MutableList<GenreEntity> = mutableListOf()
    this.forEach {
        genres.add(it.map())
    }

    return genres
}

fun GenresItemResponse?.map(): GenresItemEntity {
    return GenresItemEntity(
        name = this?.name ?: "",
        id = this?.id ?: 0
    )
}

fun GenreResponse?.map(): GenreEntity {
    val genres: MutableList<GenresItemEntity> = mutableListOf()
    this?.genres?.forEach {
        genres.add(it.map())
    }
    return GenreEntity(
        genres = genres
    )
}