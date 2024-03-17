package com.mohasihab.movie.ui.screen.home

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.mohasihab.movie.core.domain.entities.GenresItemEntity
import com.mohasihab.movie.core.domain.entities.RequestState

object HomeDestination {
    const val route = "home"
}


fun NavGraphBuilder.homeScreen(
    navigateToMovie: (genre : GenresItemEntity) -> Unit,
) {
    composable(route = HomeDestination.route, content = {
        val viewModel: HomeViewModel = hiltViewModel()
        val state = viewModel.state.collectAsState(initial = HomeState(genre = RequestState.Loading))

        LaunchedEffect(Unit) {
            viewModel.fetchGenre()
        }

        HomeScreen(
            navigateToMovie = navigateToMovie,
            state = state.value,
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