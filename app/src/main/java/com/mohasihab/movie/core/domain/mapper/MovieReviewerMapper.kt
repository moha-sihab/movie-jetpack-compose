package com.mohasihab.movie.core.domain.mapper

import com.mohasihab.movie.core.data.source.remote.response.AuthorDetailsResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieReviewResponse
import com.mohasihab.movie.core.domain.entities.AuthorDetailsEntity
import com.mohasihab.movie.core.domain.entities.MovieReviewEntity

fun List<MovieReviewResponse>?.map(): List<MovieReviewEntity> {
    val review: MutableList<MovieReviewEntity> = mutableListOf()
    this?.forEach {
        review.add(it.map())
    }
    return review
}

fun MovieReviewResponse?.map(): MovieReviewEntity {
    return MovieReviewEntity(
        authorDetails = this?.authorDetails.map(),
        updatedAt = this?.updatedAt ?: "",
        author = this?.author ?: "",
        createdAt = this?.createdAt ?: "",
        id = this?.id ?: "",
        content = this?.content ?: ""
    )
}

fun AuthorDetailsResponse?.map(): AuthorDetailsEntity {
    return AuthorDetailsEntity(
        avatarPath = this?.avatarPath ?: "",
        name = this?.name ?: "",
        rating = this?.rating ?: 0.0,
        username = this?.username ?: "",
    )
}