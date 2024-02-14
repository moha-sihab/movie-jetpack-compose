package com.mohasihab.movie.core.domain.mapper

import com.mohasihab.movie.core.data.source.remote.response.GenresItemDetailResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieDetailResponse
import com.mohasihab.movie.core.data.source.remote.response.ProductionCompaniesItemResponse
import com.mohasihab.movie.core.data.source.remote.response.SpokenLanguagesItemResponse
import com.mohasihab.movie.core.domain.entities.GenresItemDetailEntity
import com.mohasihab.movie.core.domain.entities.MovieDetailEntity
import com.mohasihab.movie.core.domain.entities.ProductionCompaniesItemEntity
import com.mohasihab.movie.core.domain.entities.SpokenLanguagesItemEntity

fun MovieDetailResponse?.map(): MovieDetailEntity {
    val genres: MutableList<GenresItemDetailEntity> = mutableListOf()
    val countries: MutableList<String> = mutableListOf()
    val spokenLanguages: MutableList<SpokenLanguagesItemEntity> = mutableListOf()
    val companies: MutableList<ProductionCompaniesItemEntity> = mutableListOf()

    this?.genres?.forEach {
        genres.add(it.map())
    }

    this?.productionCountries?.forEach {
        countries.add(it?.name ?: "")
    }

    this?.spokenLanguages?.forEach {
        spokenLanguages.add(it.map())
    }

    this?.productionCompanies?.forEach {
        companies.add(it.map())
    }

    return MovieDetailEntity(
        originalLanguage = this?.originalLanguage ?: "",
        title = this?.title ?: "",
        backdropPath = this?.backdropPath ?: "",
        genres = genres,
        productionCountries = countries,
        id = this?.id ?: 0,
        voteCount = this?.voteCount ?: 0,
        overview = this?.overview ?: "",
        originalTitle = this?.originalTitle ?: "",
        posterPath = this?.posterPath ?: "",
        spokenLanguages = spokenLanguages,
        productionCompanies = companies,
        releaseDate = this?.releaseDate ?: "",
        voteAverage = this?.voteAverage ?: 0.0,
        status = this?.status ?: ""

    )
}

fun SpokenLanguagesItemResponse?.map(): SpokenLanguagesItemEntity {
    return SpokenLanguagesItemEntity(
        name = this?.name ?: "",
        englishName = this?.englishName ?: ""
    )
}

fun ProductionCompaniesItemResponse?.map(): ProductionCompaniesItemEntity {
    return ProductionCompaniesItemEntity(
        name = this?.name ?: "",
        originCountry = this?.originCountry ?: ""
    )
}

fun GenresItemDetailResponse?.map(): GenresItemDetailEntity {
    return GenresItemDetailEntity(
        name = this?.name ?: "",
        id = this?.id ?: 0
    )
}