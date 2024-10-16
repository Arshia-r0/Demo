package com.roseoj.myapplication.feature.welcome.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roseoj.myapplication.core.data.repository.UserDataRepository
import com.roseoj.myapplication.core.model.data.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository
): ViewModel() {
    
    val uiState: StateFlow<MainActivityUiState> = userDataRepository.userData.map {
        MainActivityUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainActivityUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000)
    )
    
    fun authenticate() {
        viewModelScope.launch {
            userDataRepository.setToken(true)
        }
    }
    
}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val data: UserData) : MainActivityUiState
}
