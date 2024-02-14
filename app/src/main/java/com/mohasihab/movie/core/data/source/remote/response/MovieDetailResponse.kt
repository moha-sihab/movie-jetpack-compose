package com.mohasihab.movie.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
	@SerializedName("original_language")
	val originalLanguage: String?,
	@SerializedName("title")
	val title: String?,
	@SerializedName("backdrop_path")
	val backdropPath: String?,
	@SerializedName("genres")
	val genres: List<GenresItemDetailResponse?>?,
	@SerializedName("production_countries")
	val productionCountries: List<ProductionCountriesItemResponse?>?,
	@SerializedName("id")
	val id: Int?,
	@SerializedName("vote_count")
	val voteCount: Int?,
	@SerializedName("overview")
	val overview: String?,
	@SerializedName("original_title")
	val originalTitle: String?,
	@SerializedName("poster_path")
	val posterPath: String?,
	@SerializedName("spoken_languages")
	val spokenLanguages: List<SpokenLanguagesItemResponse?>?,
	@SerializedName("production_companies")
	val productionCompanies: List<ProductionCompaniesItemResponse?>?,
	@SerializedName("release_date")
	val releaseDate: String?,
	@SerializedName("vote_average")
	val voteAverage: Any?,
	@SerializedName("status")
	val status: String?,
)

data class GenresItemDetailResponse(
	@SerializedName("name")
	val name: String?,
	@SerializedName("id")
	val id: Int?,
)

data class ProductionCompaniesItemResponse(
	@SerializedName("logo_path")
	val logoPath: String?,
	@SerializedName("name")
	val name: String?,
	@SerializedName("id")
	val id: Int?,
	@SerializedName("origin_country")
	val originCountry: String?,
)

data class ProductionCountriesItemResponse(
	@SerializedName("iso_3166_1")
	val iso31661: String?,
	@SerializedName("name")
	val name: String?,
)

data class SpokenLanguagesItemResponse(
	@SerializedName("name")
	val name: String?,
	@SerializedName("iso_639_1")
	val iso6391: String?,
	@SerializedName("english_name")
	val englishName: String?,
)
