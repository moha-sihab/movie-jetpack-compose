package com.mohasihab.movie.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MovieTitle(movieTitle: String, modifier: Modifier = Modifier) {
    Text(
        text = movieTitle,
        modifier = modifier,
        color = Color.White,
        softWrap = true,
        textAlign = TextAlign.Center)
}