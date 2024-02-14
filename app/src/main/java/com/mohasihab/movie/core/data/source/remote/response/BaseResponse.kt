package com.mohasihab.movie.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
	@SerializedName("page")
	val page: Int?,
	@SerializedName("total_pages")
	val totalPages: Int?,
	@SerializedName("results")
	val results: T?,
	@SerializedName("total_results")
	val totalResults: Int?,
)
