package com.mohasihab.movie.core.data.interfaces

import com.mohasihab.movie.core.data.source.remote.response.GenreResponse

interface GenreRepositoryContract {
    suspend fun fetchGenres(): GenreResponse
}