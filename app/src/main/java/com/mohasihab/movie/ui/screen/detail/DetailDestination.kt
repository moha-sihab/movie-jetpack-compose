package com.mohasihab.movie.ui.screen.detail

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


object DetailDestination {
    const val route = "detail"
}


fun NavGraphBuilder.detailScreen() {
    composable(route = "${DetailDestination.route}/{movieId}", content = { navBackStackEntry ->
        val viewModel: DetailViewModel = hiltViewModel()
        val state = viewModel.state

        LaunchedEffect(Unit) {
            val movieId = navBackStackEntry.arguments?.getString("movieId") ?: ""
            viewModel.fetchDetailMovie(movieId)
        }

        DetailScreen(
            state = state
        )

    })
}

fun NavController.navigateToDetailScreen(movieId: String) {
    navigate(route = "${DetailDestination.route}/$movieId")
}