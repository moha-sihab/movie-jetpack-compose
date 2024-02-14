package com.mohasihab.movie.core.data.repositories

import com.mohasihab.movie.core.data.interfaces.MovieDiscoverRepositoryContract
import com.mohasihab.movie.core.data.source.remote.network.MovieDiscoverApi
import javax.inject.Inject

class MovieDiscoverRepository @Inject constructor(
    private val api: MovieDiscoverApi,
) : MovieDiscoverRepositoryContract {
    override suspend fun fetchDiscoverMovieByGenre(parameters: HashMap<String, String>) =
        api.fetchDiscoverMovieByGenre(parameters)
}