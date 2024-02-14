package com.mohasihab.movie.core.data.interfaces

import com.mohasihab.movie.core.data.source.remote.response.BaseResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieDetailResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieReviewResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieVideoResponse

interface MovieDetailRepositoryContract {
    suspend fun fetchMovieDetail(
        movieId: String,
    ): MovieDetailResponse

    suspend fun fetchMovieDetailReviews(
        movieId: String,
        parameters: HashMap<String, String>,
    ): BaseResponse<List<MovieReviewResponse>>

    suspend fun fetchMovieDetailVideos(
        movieId: String,
    ): BaseResponse<List<MovieVideoResponse>>
}