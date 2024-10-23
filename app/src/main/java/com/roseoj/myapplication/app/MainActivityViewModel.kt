package com.roseoj.myapplication.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roseoj.myapplication.core.data.repository.UserDataRepository
import com.roseoj.myapplication.core.model.data.UserData
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class MainActivityViewModel(
    userDataRepository: UserDataRepository
): ViewModel() {

    val uiState: StateFlow<MainActivityUiState> = userDataRepository.userData.map {
        MainActivityUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainActivityUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000)
    )

}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val data: UserData) : MainActivityUiState
}
