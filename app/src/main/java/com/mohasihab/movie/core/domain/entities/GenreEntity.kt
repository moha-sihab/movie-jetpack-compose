package com.mohasihab.movie.core.domain.entities

import androidx.compose.ui.graphics.Color

data class GenreEntity(
    val genres: List<GenresItemEntity>,
)

data class GenresItemEntity(
    val name: String,
    val id: Int,
    val cardColor : CardColorModel
)

data class CardColorModel(
    val containerColor : Color,
    val contentColor : Color,
)