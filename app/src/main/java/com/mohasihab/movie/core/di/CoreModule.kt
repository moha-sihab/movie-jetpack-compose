package com.mohasihab.movie.core.di

import com.mohasihab.movie.core.data.interfaces.GenreRepositoryContract
import com.mohasihab.movie.core.data.interfaces.MovieDetailRepositoryContract
import com.mohasihab.movie.core.data.interfaces.MovieDiscoverRepositoryContract
import com.mohasihab.movie.core.data.repositories.GenreRepository
import com.mohasihab.movie.core.data.repositories.MovieDetailRepository
import com.mohasihab.movie.core.data.repositories.MovieDiscoverRepository
import com.mohasihab.movie.core.data.source.remote.network.GenreApi
import com.mohasihab.movie.core.data.source.remote.network.MovieDetailApi
import com.mohasihab.movie.core.data.source.remote.network.MovieDiscoverApi
import com.mohasihab.movie.core.domain.interfaces.GenreUseCaseContract
import com.mohasihab.movie.core.domain.interfaces.MovieDetailUseCaseContract
import com.mohasihab.movie.core.domain.interfaces.MovieDiscoverUseCaseContract
import com.mohasihab.movie.core.domain.interfaces.MovieReviewUseCaseContract
import com.mohasihab.movie.core.domain.interfaces.MovieVideoUseCaseContract
import com.mohasihab.movie.core.domain.usecase.GenreUseCase
import com.mohasihab.movie.core.domain.usecase.MovieDetailUseCase
import com.mohasihab.movie.core.domain.usecase.MovieDiscoverUseCase
import com.mohasihab.movie.core.domain.usecase.MovieReviewUseCase
import com.mohasihab.movie.core.domain.usecase.MovieVideoUseCase
import com.mohasihab.movie.core.helper.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Singleton
    @Provides
    fun providesGenreApi(): GenreApi {
        return NetworkHelper.retrofitClient().create(GenreApi::class.java)
    }

    @Singleton
    @Provides
    fun providesMovieDetailApi(): MovieDetailApi {
        return NetworkHelper.retrofitClient().create(MovieDetailApi::class.java)
    }

    @Singleton
    @Provides
    fun providesMovieDiscoverApi(): MovieDiscoverApi {
        return NetworkHelper.retrofitClient().create(MovieDiscoverApi::class.java)
    }

    @Singleton
    @Provides
    fun providesGenreRepository(api: GenreApi): GenreRepositoryContract = GenreRepository(api)

    @Singleton
    @Provides
    fun providesMovieDetailRepository(api: MovieDetailApi): MovieDetailRepositoryContract =
        MovieDetailRepository(api)

    @Singleton
    @Provides
    fun providesMovieDiscoverRepository(api: MovieDiscoverApi): MovieDiscoverRepositoryContract =
        MovieDiscoverRepository(api)

    @Singleton
    @Provides
    fun provideGenreUseCase(repository: GenreRepositoryContract): GenreUseCaseContract =
        GenreUseCase(repository)

    @Singleton
    @Provides
    fun provideMovieDetailUseCase(repository: MovieDetailRepositoryContract): MovieDetailUseCaseContract =
        MovieDetailUseCase(repository)

    @Singleton
    @Provides
    fun provideMovieDiscoverUseCase(repository: MovieDiscoverRepositoryContract): MovieDiscoverUseCaseContract =
        MovieDiscoverUseCase(repository)

    @Singleton
    @Provides
    fun provideMovieReviewUseCase(repository: MovieDetailRepositoryContract): MovieReviewUseCaseContract =
        MovieReviewUseCase(repository)

    @Singleton
    @Provides
    fun provideMovieVideoUseCase(repository: MovieDetailRepositoryContract): MovieVideoUseCaseContract =
        MovieVideoUseCase(repository)
}