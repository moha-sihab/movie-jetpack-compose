package com.mohasihab.movie.ui.screen.detail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohasihab.movie.ui.screen.movie.MovieScreen


object DetailDestination {
    const val route = "detail"
}


fun NavGraphBuilder.detailScreen() {
    composable(route = DetailDestination.route, content = {
        /*   val viewModel: HomeViewModel = koinViewModel()
           val state: HomeState by viewModel.state.collectAsStateWithLifecycle()
   */

        DetailScreen()

    })
}

fun NavController.navigateToDetailScreen() {
    navigate(route = DetailDestination.route)
}