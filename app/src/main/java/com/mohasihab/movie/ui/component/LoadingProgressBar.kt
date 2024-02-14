package com.mohasihab.movie.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoadingProgressBar() {
    CircularProgressIndicator(
        modifier = Modifier.size(100.dp),
        color = MaterialTheme.colorScheme.tertiary,
        strokeWidth = 10.dp
    )
}