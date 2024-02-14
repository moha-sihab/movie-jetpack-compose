package com.mohasihab.movie.ui.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.mohasihab.movie.ui.theme.Spacing

@Composable
fun MovieRating(rating: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Spacing().small),
        verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = null,
            tint = Color.Yellow,
        )
        Text(
            text = rating,
            color = Color.White,
            softWrap = true,
            textAlign = TextAlign.Center
        )
    }

}