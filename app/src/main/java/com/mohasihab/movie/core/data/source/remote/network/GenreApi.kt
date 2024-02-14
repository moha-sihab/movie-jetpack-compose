package com.mohasihab.movie.core.data.source.remote.network

import com.mohasihab.movie.core.data.source.remote.response.GenreResponse
import com.mohasihab.moviejetpackcompose.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreApi {
    @GET("/3/genre/movie/list")
    suspend fun fetchGenres(
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ): GenreResponse
}