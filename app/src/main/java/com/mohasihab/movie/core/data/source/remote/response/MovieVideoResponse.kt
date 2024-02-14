package com.mohasihab.movie.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieVideoResponse(
	@SerializedName("site")
	val site: String?,
	@SerializedName("size")
	val size: Int?,
	@SerializedName("name")
	val name: String?,
	@SerializedName("official")
	val official: Boolean?,
	@SerializedName("id")
	val id: String?,
	@SerializedName("type")
	val type: String?,
	@SerializedName("published_at")
	val publishedAt: String?,
	@SerializedName("key")
	val key: String?
)
