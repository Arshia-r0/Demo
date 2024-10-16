package com.roseoj.myapplication.feature.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roseoj.myapplication.core.data.repository.UserDataRepository
import com.roseoj.myapplication.core.model.data.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    userDataRepository: UserDataRepository
): ViewModel() {


    val uiState: StateFlow<AuthScreenUiState> = userDataRepository.userData.map {
        AuthScreenUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = AuthScreenUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000)
    )

}

sealed interface AuthScreenUiState {
    data object Loading : AuthScreenUiState
    data class Success(val data: UserData) : AuthScreenUiState
}
