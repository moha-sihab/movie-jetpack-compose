package com.mohasihab.movie.core.data.source.remote.network

import com.mohasihab.movie.core.data.source.remote.response.GenreResponse
import retrofit2.http.GET

interface GenreApi {
    @GET("/3/genre/movie/list")
    suspend fun fetchGenres(): GenreResponse
}