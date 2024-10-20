package com.roseoj.myapplication.feature.welcome.auth

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roseoj.myapplication.core.data.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository
): ViewModel() {
    
    val phoneNumber = mutableStateOf("")
    val isChecked = mutableStateOf(false)
    
    fun setPhoneNumber(newNumber: String) { phoneNumber.value = newNumber }
    
    fun setIsChecked(newIsChecked: Boolean) { isChecked.value = newIsChecked }
    
    private fun authenticate() {
        viewModelScope.launch {
            userDataRepository.setAuthorization(true)
        }
    }
    
}
