package com.mohasihab.movie.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mohasihab.movie.core.domain.entities.GenreEntity
import com.mohasihab.movie.core.domain.entities.GenresItemEntity
import com.mohasihab.movie.core.domain.entities.ResultState
import com.mohasihab.movie.ui.component.AppTopBar
import com.mohasihab.movie.ui.component.ErrorLayout
import com.mohasihab.movie.ui.component.LoadingProgressBar
import com.mohasihab.movie.ui.theme.MovieTheme
import com.mohasihab.movie.ui.theme.Spacing
import com.mohasihab.moviejetpackcompose.R


@Composable
fun HomeScreen(
    navigateToMovie: (genre: GenresItemEntity) -> Unit,
    genres: ResultState<GenreEntity>,
    state: HomeState,
    viewModel: HomeViewModel,
) {
    MovieTheme {
        Scaffold(
            topBar = {
                AppTopBar(
                    titleTopBar = stringResource(R.string.app_bar_title)
                )
            },
            containerColor = MaterialTheme.colorScheme.background,
        ) { innerPadding ->
            when (genres) {

                is ResultState.Loading -> {
                    LoadingProgressBar()
                }

                is ResultState.Success -> {
                    genres.data?.let {
                        HomeContent(
                            paddingValues = innerPadding,
                            genres = it,
                            navigateToMovie = navigateToMovie,
                            state = state,
                            viewModel = viewModel
                        )
                    }
                }

                is ResultState.Error -> {
                    ErrorLayout(error = genres.message.toString())
                }

                else -> {}
            }

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeContent(
    paddingValues: PaddingValues,
    genres: GenreEntity,
    state: HomeState,
    viewModel: HomeViewModel,
    navigateToMovie: (genre: GenresItemEntity) -> Unit,
) {
    val listState = rememberLazyGridState()
    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.genre is ResultState.Loading,
        onRefresh = { viewModel.fetchGenre() }
    )
    LazyVerticalGrid(
        modifier = Modifier
            .padding(paddingValues)
            .pullRefresh(pullRefreshState),
        columns = GridCells.Fixed(2),
        state = listState
    ) {
        item(span = { GridItemSpan(2) }) { ->
            Column(
                modifier = Modifier
                    .padding(Spacing().medium)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(id = R.string.sub_header_genre_title),
                    style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
            }
        }

        items(genres.genres, key = { it.id }) { genre ->
            GenreItem(modifier = Modifier, genre = genre, navigateToMovie = navigateToMovie)
        }
    }


}

@Composable
fun GenreItem(
    modifier: Modifier,
    genre: GenresItemEntity,
    navigateToMovie: (genre: GenresItemEntity) -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                navigateToMovie(genre)
            }
            .height(height = 100.dp)
            .padding(start = Spacing().medium, top = Spacing().medium),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = genre.cardColor.containerColor,
            contentColor = genre.cardColor.contentColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing().medium),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                text = genre.name,
                style = MaterialTheme.typography.bodyMedium,
                softWrap = true,
            )

        }
    }
}