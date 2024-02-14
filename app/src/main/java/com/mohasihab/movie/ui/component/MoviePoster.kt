package com.mohasihab.movie.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MoviePoster(
    posterPath: String,
    movieTitle: String,
    modifier: Modifier = Modifier,
) {
    val painter = rememberAsyncImagePainter(
        model = posterPath,
        error = rememberVectorPainter(Icons.Filled.ThumbUp),
        placeholder = rememberVectorPainter(Icons.Default.Add)
    )

    Image(
        painter = painter,
        contentDescription = movieTitle,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(200.dp)
    )


}
