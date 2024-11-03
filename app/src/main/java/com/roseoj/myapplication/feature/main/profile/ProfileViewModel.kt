package com.roseoj.myapplication.feature.main.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roseoj.myapplication.core.data.repository.UserDataRepository
import kotlinx.coroutines.launch


class ProfileViewModel(
    val userDataRepository: UserDataRepository
) : ViewModel() {
    
    val items = listOf(
        "اطلاعات حساب کاربری",
        "علاقمندی ها",
        "آدرس ها",
        "سوالات متداول",
        "قوانین",
        "تماس با ما",
    )
    
    fun logout() {
        viewModelScope.launch {
            userDataRepository.setAuthorization(false)
        }
    }
    
}