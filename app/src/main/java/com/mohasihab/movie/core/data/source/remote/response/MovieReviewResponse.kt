package com.mohasihab.movie.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieReviewResponse(
	@SerializedName("author_details")
	val authorDetails: AuthorDetailsResponse?,
	@SerializedName("updated_at")
	val updatedAt: String?,
	@SerializedName("author")
	val author: String?,
	@SerializedName("created_at")
	val createdAt: String?,
	@SerializedName("id")
	val id: String?,
	@SerializedName("content")
	val content: String?,
)

data class AuthorDetailsResponse(
	@SerializedName("avatar_path")
	val avatarPath: String?,
	@SerializedName("name")
	val name: String?,
	@SerializedName("rating")
	val rating: Double?,
	@SerializedName("username")
	val username: String?
)
