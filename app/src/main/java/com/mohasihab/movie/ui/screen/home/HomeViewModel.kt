package com.mohasihab.movie.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohasihab.movie.core.domain.interfaces.GenreUseCaseContract
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase : GenreUseCaseContract
) : ViewModel() {
    var state by mutableStateOf(HomeState())
    fun fetchGenre(){
        viewModelScope.launch {
            useCase.fetchGenre().collect {
                state = state.copy(genre = it)
            }
        }
    }
}