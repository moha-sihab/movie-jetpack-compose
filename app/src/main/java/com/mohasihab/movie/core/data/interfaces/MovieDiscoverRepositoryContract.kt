package com.mohasihab.movie.core.data.interfaces

import com.mohasihab.movie.core.data.source.remote.response.BaseResponse
import com.mohasihab.movie.core.data.source.remote.response.MovieDiscoverResponse

interface MovieDiscoverRepositoryContract {
    suspend fun fetchDiscoverMovieByGenre(
        parameters: HashMap<String, String>,
    ): BaseResponse<List<MovieDiscoverResponse>>
}