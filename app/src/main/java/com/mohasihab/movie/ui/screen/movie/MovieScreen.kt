package com.mohasihab.movie.ui.screen.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mohasihab.movie.core.domain.entities.MovieDiscoverEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import com.mohasihab.movie.ui.component.AppTopBar
import com.mohasihab.movie.ui.component.ErrorLayout
import com.mohasihab.movie.ui.component.LoadingProgressBar
import com.mohasihab.movie.ui.component.MoviePoster
import com.mohasihab.movie.ui.component.MovieRating
import com.mohasihab.movie.ui.component.MovieTitle
import com.mohasihab.movie.ui.component.ShouldLoadMore
import com.mohasihab.movie.ui.theme.MovieTheme
import com.mohasihab.movie.ui.theme.Spacing
import com.mohasihab.moviejetpackcompose.R

@Composable
fun MovieScreen(
    navigateToDetailMovie: (movieId: String) -> Unit,
    state: MovieState,
    viewModel: MovieViewModel,
) {
    MovieTheme {
        Scaffold(
            topBar = {
                AppTopBar(
                    titleTopBar = state.genre.name
                )
            },
            containerColor = MaterialTheme.colorScheme.background,
        ) { innerPadding ->

            when (state.movies) {

                is ResultState.Loading -> {
                    LoadingProgressBar()
                }

                is ResultState.Success -> {
                    state.movies.data?.let {
                        MovieContent(
                            paddingValues = innerPadding,
                            navigateToDetailMovie = navigateToDetailMovie,
                            state = state,
                            viewModel = viewModel,
                            movies = it
                        )
                    }
                }

                is ResultState.Error -> {
                    ErrorLayout(error = state.movies.message.toString())
                }

                else -> {}
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieContent(
    paddingValues: PaddingValues,
    movies: List<MovieDiscoverEntity>,
    state: MovieState,
    viewModel: MovieViewModel,
    navigateToDetailMovie: (movieId: String) -> Unit,
) {
    val listState = rememberLazyGridState()
    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.movies is ResultState.Loading,
        onRefresh = { viewModel.fetchMovieByGenre(state.genre.id.toString(), 1) }
    )
    listState.ShouldLoadMore {
        viewModel.fetchMovieByGenre(state.genre.id.toString(), viewModel.page + 1)
    }

    LazyVerticalGrid(
        modifier = Modifier
            .padding(paddingValues)
            .pullRefresh(pullRefreshState),
        columns = GridCells.Fixed(2),
        state = listState,
        flingBehavior =  ScrollableDefaults.flingBehavior(),
        userScrollEnabled = true
    ) {
        item(span = { GridItemSpan(2) }) { ->
            Column(
                modifier = Modifier
                    .padding(Spacing().medium)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(id = R.string.header_genre_title, state.genre.name),
                    style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Start,
                    softWrap = true
                )
            }
        }

        items(movies, key = { it.id }) { movie ->
            MovieItem(
                modifier = Modifier,
                movie = movie,
                navigateToDetailMovie = navigateToDetailMovie
            )
        }
    }
}

@Composable
fun MovieItem(
    movie: MovieDiscoverEntity,
    modifier: Modifier,
    navigateToDetailMovie: (movieId: String) -> Unit,
) {

    Box(modifier = modifier
        .clickable { navigateToDetailMovie(movie.id.toString()) }
        .padding(Spacing().medium)
        .clip(RoundedCornerShape(20.dp))
    ) {

        MoviePoster(
            posterPath = movie.posterPath,
            movieTitle = movie.title,
        )

        Surface(
            color = Color.Black.copy(alpha = 0.4f),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .fillMaxHeight(),
            shape = RoundedCornerShape(bottomStart = 16.dp)
        ) {
            MovieRating(
                rating = movie.voteAverage.toString().take(3),
                modifier = Modifier.padding(5.dp)
            )
        }

        Surface(
            color = Color.Black.copy(alpha = 0.4f),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxSize()
                .fillMaxHeight()
        ) {
            MovieTitle(
                movieTitle = movie.title,
                modifier = Modifier.padding(5.dp)
            )
        }


    }
}