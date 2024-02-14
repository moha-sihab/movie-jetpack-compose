package com.mohasihab.movie.core.data.source.remote.network

import com.mohasihab.movie.core.data.source.remote.response.BaseResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieDetailResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieReviewResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieVideoResponse
import com.mohasihab.moviejetpackcompose.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieDetailApi {
    @GET("/3/movie/{movieId}")
    suspend fun fetchMovieDetail(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ): MovieDetailResponse

    @GET("/3/movie/{movieId}/reviews")
    suspend fun fetchMovieDetailReviews(
        @Path("movieId") movieId: String,
        @QueryMap parameters: HashMap<String, String>,
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ): BaseResponse<List<MovieReviewResponse>>

    @GET("/3/movie/{movieId}/videos")
    suspend fun fetchMovieDetailVideos(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ): BaseResponse<List<MovieVideoResponse>>
}