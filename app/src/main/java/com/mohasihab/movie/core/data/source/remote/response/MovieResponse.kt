package com.mohasihab.movie.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
	@SerializedName("title")
	val title: String?,
	@SerializedName("poster_path")
	val posterPath: String?,
	@SerializedName("vote_average")
	val voteAverage: Any?,
	@SerializedName("id")
	val id: Int?,
)
