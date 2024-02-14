package com.mohasihab.movie.core.data.repositories

import com.mohasihab.movie.core.data.interfaces.GenreRepositoryContract
import com.mohasihab.movie.core.data.source.remote.network.GenreApi
import javax.inject.Inject

class GenreRepository @Inject constructor(
    private val api: GenreApi,
) : GenreRepositoryContract {
    override suspend fun fetchGenres() = api.fetchGenres()
}