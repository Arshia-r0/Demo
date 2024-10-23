package com.roseoj.myapplication.feature.welcome.auth

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roseoj.myapplication.core.data.repository.UserDataRepository
import kotlinx.coroutines.launch


const val countDownTime = 120 // in seconds

class AuthScreenViewModel(
    private val userDataRepository: UserDataRepository
): ViewModel() {
    
    val authStage = mutableStateOf(AuthStage.PhoneNumber)
    val phoneNumber = mutableStateOf(TextFieldValue())
    val otp = mutableStateOf(TextFieldValue())
    val otpError = mutableStateOf(false)
    val isChecked = mutableStateOf(false)
    val invalidNumber = mutableStateOf(false)
    val timeLeft = mutableIntStateOf(countDownTime)
    val countDown = mutableStateOf(false)
    
    fun setPhoneNumber(newNumber: TextFieldValue) {
        if(newNumber.text.all(Char::isDigit)) {
            phoneNumber.value = newNumber
        }
    }
    
    fun setOtp(newOtp: TextFieldValue) {
        if(newOtp.text.all(Char::isDigit) && newOtp.text.length <= 5) {
            otp.value = newOtp
            otpError.value = false
        }
    }
    
    fun setIsChecked(newIsChecked: Boolean) { isChecked.value = newIsChecked }
    
    fun submitPhoneNumber() {
        if(validatePhoneNumber()) {
            authStage.value = AuthStage.Otp
            requestOtp()
        }
    }
    
    fun submitOtp() {
        if(validateOtp()) {
            countDown.value = false
            authenticate()
        }
    }
    
    fun requestOtp() {
        timeLeft.intValue = countDownTime
        countDown.value = true
        otp.value = TextFieldValue()
        otpError.value = false
    }
    
    private fun validatePhoneNumber(): Boolean = when {
        phoneNumber.value.text != "123"-> false.also {
            invalidNumber.value = true
        }
        !isChecked.value -> false
        else -> true
    }
    
    private fun validateOtp(): Boolean = when {
        otp.value.text == "11111" -> true
        else -> false.also {
            if(otp.value.text.length == 5) otpError.value = true
        }
    }
    
    private fun authenticate() {
        viewModelScope.launch {
            userDataRepository.setAuthorization(true)
        }
    }
    
}

enum class AuthStage {
    PhoneNumber,
    Otp
}
