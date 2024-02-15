package com.mohasihab.movie.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mohasihab.movie.ui.screen.detail.detailScreen
import com.mohasihab.movie.ui.screen.detail.navigateToDetailScreen
import com.mohasihab.movie.ui.screen.home.HomeDestination
import com.mohasihab.movie.ui.screen.home.homeScreen
import com.mohasihab.movie.ui.screen.movie.movieScreen
import com.mohasihab.movie.ui.screen.movie.navigateToMovieScreen
import com.mohasihab.movie.ui.theme.MovieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTheme {
                // A surface container using the 'background' color from the theme
                val navController: NavHostController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        containerColor = MaterialTheme.colorScheme.background,
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = HomeDestination.route,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            homeScreen(
                                navigateToMovie = {
                                    navController.navigateToMovieScreen(it.id.toString(),it.name)
                                }
                            )
                            movieScreen(navigateToDetailMovie = {
                                navController.navigateToDetailScreen(it)
                            })
                            detailScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieTheme {
        Greeting("Android")
    }
}