package com.mohasihab.movie.core.domain.entities

data class GenreEntity(
    val genres: List<GenresItemEntity>,
)

data class GenresItemEntity(
    val name: String,
    val id: Int,
)
