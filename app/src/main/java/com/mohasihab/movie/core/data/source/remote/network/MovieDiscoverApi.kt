package com.mohasihab.movie.core.data.source.remote.network

import com.mohasihab.movie.core.data.source.remote.response.BaseResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieDiscoverResponse
import com.mohasihab.moviejetpackcompose.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieDiscoverApi {
    @GET("/3/discover/movie")
    suspend fun fetchDiscoverMovieByGenre(
        @QueryMap parameters: HashMap<String, String>,
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ): BaseResponse<List<MovieDiscoverResponse>>
}