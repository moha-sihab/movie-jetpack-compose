package com.mohasihab.movie.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohasihab.movie.core.domain.interfaces.GenreUseCaseContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GenreUseCaseContract
) : ViewModel() {
    var state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    fun fetchGenre() {
        viewModelScope.launch {
            useCase.fetchGenre().collect {
                state.value = state.value.copy(genre = it)
            }
        }
    }
}