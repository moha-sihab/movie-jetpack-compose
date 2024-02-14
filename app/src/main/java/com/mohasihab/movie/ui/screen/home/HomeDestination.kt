package com.mohasihab.movie.ui.screen.home

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.mohasihab.movie.core.domain.entities.GenresItemEntity

object HomeDestination {
    const val route = "home"
}


fun NavGraphBuilder.homeScreen(
    navigateToMovie: (genre : GenresItemEntity) -> Unit,
) {
    composable(route = HomeDestination.route, content = {
        val viewModel: HomeViewModel = hiltViewModel()
        val state = viewModel.state

        LaunchedEffect(Unit) {
            viewModel.fetchGenre()
        }

        HomeScreen(
            navigateToMovie = navigateToMovie,
            genres = state.genre,
            state = state,
            viewModel = viewModel
        )

    })
}

fun NavController.navigateToHomeScreen(
    builder: NavOptionsBuilder.(route: String) -> Unit = {},
) {
    navigate(route = HomeDestination.route, builder = {
        builder(HomeDestination.route)
    })
}