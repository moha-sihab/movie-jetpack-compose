package com.mohasihab.movie.core.domain.mapper

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.mohasihab.movie.core.data.source.remote.response.GenreResponse
import com.mohasihab.movie.core.data.source.remote.response.GenresItemResponse
import com.mohasihab.movie.core.domain.entities.CardColorModel
import com.mohasihab.movie.core.domain.entities.GenreEntity
import com.mohasihab.movie.core.domain.entities.GenresItemEntity
import com.mohasihab.movie.ui.theme.BlueContainer
import com.mohasihab.movie.ui.theme.GreenContainer
import com.mohasihab.movie.ui.theme.OnBlueContainer
import com.mohasihab.movie.ui.theme.OnGreenContainer
import com.mohasihab.movie.ui.theme.OnOrangeContainer
import com.mohasihab.movie.ui.theme.OnPurpleContainer
import com.mohasihab.movie.ui.theme.OrangeContainer
import com.mohasihab.movie.ui.theme.PurpleContainer

fun GenresItemResponse?.map(): GenresItemEntity {
    val magicNumber = listOf(0,1,2,3)
    val cardColorList : MutableList<CardColorModel> = mutableListOf()
    val cardColor1 = CardColorModel(
        containerColor = GreenContainer,
        contentColor = OnGreenContainer,
    )
    val cardColor2 = CardColorModel(
        containerColor = BlueContainer,
        contentColor = OnBlueContainer,
    )
    val cardColor3 = CardColorModel(
        containerColor = PurpleContainer,
        contentColor = OnPurpleContainer,
    )
    val cardColor4 = CardColorModel(
        containerColor = OrangeContainer,
        contentColor = OnOrangeContainer,
    )

    cardColorList.add(cardColor1)
    cardColorList.add(cardColor2)
    cardColorList.add(cardColor3)
    cardColorList.add(cardColor4)

    val randomMagicNumber = magicNumber.random()

    return GenresItemEntity(
        name = this?.name ?: "",
        id = this?.id ?: 0,
        cardColor = cardColorList[randomMagicNumber]
    )
}

fun GenreResponse?.map(): GenreEntity {
    val genres: MutableList<GenresItemEntity> = mutableListOf()
    this?.genres?.forEach {
        genres.add(it.map())
    }
    return GenreEntity(
        genres = genres
    )
}