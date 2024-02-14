package com.mohasihab.movie.core.domain.entities

data class MovieVideoEntity(
    val site: String,
    val size: Int,
    val name: String,
    val official: Boolean,
    val id: String,
    val type: String,
    val publishedAt: String,
    val key: String,
)