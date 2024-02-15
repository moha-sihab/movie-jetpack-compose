package com.mohasihab.movie.ui.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mohasihab.movie.core.domain.entities.MovieDetailEntity
import com.mohasihab.movie.core.domain.entities.MovieReviewEntity
import com.mohasihab.movie.core.domain.entities.MovieVideoEntity
import com.mohasihab.movie.core.helper.youtubeThumbnail
import com.mohasihab.movie.ui.component.AppTopBar
import com.mohasihab.movie.ui.component.ErrorLayout
import com.mohasihab.movie.ui.component.MoviePoster
import com.mohasihab.movie.ui.component.MovieRating
import com.mohasihab.movie.ui.component.MovieTitle
import com.mohasihab.movie.ui.theme.MovieTheme
import com.mohasihab.movie.ui.theme.Spacing

@Composable
fun DetailScreen(
    state: DetailState,
) {
    MovieTheme {
        Scaffold(
            topBar = {
                AppTopBar(
                    titleTopBar = state.movie.data?.title ?: ""
                )
            },
            containerColor = MaterialTheme.colorScheme.background,
        ) { innerPadding ->
            DetailContent(paddingValues = innerPadding, state)
        }
    }
}

@Composable
fun DetailContent(paddingValues: PaddingValues, state: DetailState) {
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.padding(paddingValues),
        state = listState
    ) {
        item {
            state.movie.data.let { movie ->
                DetailMovieHeader(movie = movie)
            }
        }
        item {
            Column(
                modifier = Modifier
                    .padding(Spacing().medium)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier,
                    text = "Trailers : ",
                    style = MaterialTheme.typography.headlineSmall.copy(color = MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Start,
                    softWrap = true
                )
            }
        }
        item {
            state.videos.data.let { videos ->
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(Spacing().medium, Alignment.Start)
                ) {
                    items(items = videos ?: mutableListOf()) {
                        DetailMovieVideos(videos = it)
                    }
                }
            }

            if (state.reviews.data?.isEmpty() == true) {
                ErrorLayout(error = "No Videos")
            }

        }
        item {
            Column(
                modifier = Modifier
                    .padding(Spacing().medium)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier,
                    text = "Reviews : ",
                    style = MaterialTheme.typography.headlineSmall.copy(color = MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Start,
                    softWrap = true
                )
            }
        }
        item {
            state.reviews.data.let { reviews ->
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(Spacing().medium, Alignment.Start)
                ) {
                    items(items = reviews ?: mutableListOf()) {
                        DetailMovieReviewItem(review = it)
                    }
                }
            }

            if (state.reviews.data?.isEmpty() == true) {
                ErrorLayout(error = "No Reviews")
            }

        }
    }
}

@Composable
fun DetailMovieHeader(movie: MovieDetailEntity?) {
    val genres = movie?.genres?.joinToString(separator = " | ") { it.name }
    val releaseDateCountry =
        "${movie?.releaseDate?.take(4)} | ${movie?.productionCountries?.joinToString(" | ") { it }}"
    val languages =
        movie?.spokenLanguages?.joinToString(separator = " | ") { it.englishName }
    val companies =
        movie?.productionCompanies?.joinToString(separator = " | ") { it.name }

    Column(
        modifier = Modifier.padding(Spacing().small),
        verticalArrangement = Arrangement.spacedBy(Spacing().medium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MoviePoster(
            posterPath = movie?.backdropPath.toString(),
            movieTitle = movie?.title.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.FillWidth
        )

        MovieTitle(
            movieTitle = movie?.title.toString(),
            style = MaterialTheme.typography.displayMedium
        )

        Text(
            text = genres.toString(),
            color = Color.White,
            softWrap = true,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center
        )

        Text(
            text = releaseDateCountry,
            color = Color.White,
            softWrap = true,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center
        )

        Text(
            text = languages.toString(),
            color = Color.White,
            softWrap = true,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = companies.toString(),
            color = Color.White,
            softWrap = true,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Overview : ",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Spacing().medium),
            color = Color.White,
            softWrap = true,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Start
        )

        Text(
            text = movie?.overview.toString(),
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            softWrap = true,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun DetailMovieReviewItem(review: MovieReviewEntity) {
    val content =
        if (review.content.length > 220) "${review.content.take(220)}...." else review.content
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(height = 300.dp)
            .padding(
                start = Spacing().medium,
                end = Spacing().medium,
                top = Spacing().small,
                bottom = Spacing().small
            ),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing().small)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = Spacing().small, end = Spacing().small, top = Spacing().small),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                MovieRating(rating = review.authorDetails.rating.toString())
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center),
                    text = "${review.authorDetails.name} | ${review.authorDetails.username}",
                    style = MaterialTheme.typography.labelMedium,
                    softWrap = true,
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Spacing().small),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                thickness = 1.dp
            )

            Text(
                text = content,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Spacing().medium),
                softWrap = true,
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Start
            )
        }

    }
}

@Composable
fun DetailMovieVideos(videos: MovieVideoEntity) {
    Box(modifier = Modifier
        .clickable { }
        .padding(Spacing().medium)
        .clip(RoundedCornerShape(20.dp))
    ) {
        MoviePoster(posterPath = videos.key.youtubeThumbnail(), movieTitle = videos.name)
    }

}