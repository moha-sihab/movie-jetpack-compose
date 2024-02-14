package com.mohasihab.movie.ui.screen.detail
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.mohasihab.movie.ui.screen.home.HomeContent
import com.mohasihab.movie.ui.theme.MovieTheme
import com.mohasihab.movie.ui.theme.Spacing

@Composable
fun DetailScreen(){
    MovieTheme {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
        ) { innerPadding ->
            DetailContent(paddingValues = innerPadding)
        }
    }
}

@Composable
fun DetailContent(paddingValues : PaddingValues){
    Column(
        modifier = Modifier.padding(Spacing().medium)
    ) {
        Text(
            modifier = Modifier
                .weight(0.9f)
                .clickable {

                },
            text = "Detail Screen",
            style = MaterialTheme.typography.displayMedium.copy(color = MaterialTheme.colorScheme.onBackground),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DetailItem(){
}