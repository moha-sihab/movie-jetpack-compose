package com.mohasihab.movie.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GenreResponse(
	@SerializedName("genres")
	val genres: List<GenresItemResponse?>?,
)

data class GenresItemResponse(
	@SerializedName("name")
	val name: String?,
	@SerializedName("id")
	val id: Int?,
)
