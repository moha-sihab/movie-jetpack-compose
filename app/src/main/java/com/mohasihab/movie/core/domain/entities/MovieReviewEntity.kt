package com.mohasihab.movie.core.domain.entities

data class MovieReviewEntity(
    val authorDetails: AuthorDetailsEntity,
    val updatedAt: String,
    val author: String,
    val createdAt: String,
    val id: String,
    val content: String,
)

data class AuthorDetailsEntity(
    val avatarPath: String,
    val name: String,
    val rating: Double,
    val username: String,
)
