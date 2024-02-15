package com.mohasihab.movie.ui.screen.movie

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohasihab.movie.core.domain.entities.CardColorModel
import com.mohasihab.movie.core.domain.entities.GenresItemEntity
import com.mohasihab.movie.ui.theme.BlueContainer
import com.mohasihab.movie.ui.theme.OnBlueContainer


object MovieDestination {
    const val route = "movie"
}

fun NavGraphBuilder.movieScreen(navigateToDetailMovie: (movieId: String) -> Unit) {
    composable(
        route = "${MovieDestination.route}/{genreId}/{genreName}",
        content = { navBackStackEntry ->
            val viewModel: MovieViewModel = hiltViewModel()
            val state = viewModel.state

            LaunchedEffect(Unit) {
                val genreId = navBackStackEntry.arguments?.getString("genreId") ?: ""
                val genreName = navBackStackEntry.arguments?.getString("genreName") ?: ""
                viewModel.fetchMovieByGenre(genreId,1)
                viewModel.setGenre(
                    GenresItemEntity(
                        id = genreId.toInt(),
                        name = genreName,
                        cardColor = CardColorModel(
                            containerColor = BlueContainer,
                            contentColor = OnBlueContainer
                        )
                    )
                )
            }

            MovieScreen(
                navigateToDetailMovie = navigateToDetailMovie, state = state, viewModel = viewModel
            )

        })
}

fun NavController.navigateToMovieScreen(genreId: String, genreName: String) {
    navigate(route = "${MovieDestination.route}/$genreId/$genreName")
}