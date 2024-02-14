package com.mohasihab.movie.core.domain.entities

data class MovieDetailEntity(
    val originalLanguage: String,
    val title: String,
    val backdropPath: String,
    val genres: List<GenresItemDetailEntity>,
    val productionCountries: List<String>,
    val id: Int,
    val voteCount: Int,
    val overview: String,
    val originalTitle: String,
    val posterPath: String,
    val spokenLanguages: List<SpokenLanguagesItemEntity>,
    val productionCompanies: List<ProductionCompaniesItemEntity>,
    val releaseDate: String,
    val voteAverage: Double,
    val status: String,
)

data class GenresItemDetailEntity(
    val name: String,
    val id: Int,
)

data class ProductionCompaniesItemEntity(
    val name: String,
    val originCountry: String,
)

data class SpokenLanguagesItemEntity(
    val name: String,
    val englishName: String,
)
