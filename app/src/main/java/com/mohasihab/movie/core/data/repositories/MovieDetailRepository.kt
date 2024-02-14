package com.mohasihab.movie.core.data.repositories

import com.mohasihab.movie.core.data.interfaces.MovieDetailRepositoryContract
import com.mohasihab.movie.core.data.source.remote.network.MovieDetailApi
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(
    private val api: MovieDetailApi,
) : MovieDetailRepositoryContract {
    override suspend fun fetchMovieDetail(movieId: String) = api.fetchMovieDetail(movieId)

    override suspend fun fetchMovieDetailReviews(
        movieId: String,
        parameters: HashMap<String, String>,
    ) = api.fetchMovieDetailReviews(movieId, parameters)

    override suspend fun fetchMovieDetailVideos(movieId: String) =
        api.fetchMovieDetailVideos(movieId)
}