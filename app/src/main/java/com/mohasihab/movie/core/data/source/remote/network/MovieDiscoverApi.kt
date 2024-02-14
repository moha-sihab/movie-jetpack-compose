package com.mohasihab.movie.core.data.source.remote.network

import com.mohasihab.movie.core.data.source.remote.response.BaseResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MovieDiscoverApi {
    @GET("/3/discover/movie")
    suspend fun fetchDiscoverMovieByGenre(
        @QueryMap parameters: HashMap<String, String>,
    ): BaseResponse<List<MovieResponse>>
}