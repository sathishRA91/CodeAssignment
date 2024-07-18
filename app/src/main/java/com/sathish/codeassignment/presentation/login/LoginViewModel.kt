package com.sathish.codeassignment.presentation.login

import androidx.lifecycle.ViewModel
import com.sathish.codeassignment.presentation.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by sathish on 11,July,2024
 */

class LoginViewModel : ViewModel() {

    private val loginState = MutableStateFlow(LoginState())
    val getLoginState = loginState.asStateFlow()

    private val _uiState = MutableStateFlow<UiState<Boolean>>(UiState.Idle())
    val uiState = _uiState.asStateFlow()

    fun userNameChange(name: String) {
        loginState.update {
            it.copy(userName = name, userNameError = null)
        }
    }

    fun passwordChange(password: String) {
        loginState.update {
            it.copy(password = password)
        }
    }

     fun validateInput(): Boolean {
        var isValid = true
        if (loginState.value.userName.isEmpty()) {
            loginState.value = loginState.value.copy(userNameError = "Username cannot be empty")
            isValid = false
        }
        return isValid
    }

    fun onLoginClicked() {
        if (validateInput()) {
            _uiState.value =UiState.Success(true)
        }
    }

    fun resetState()
    {
        _uiState.value =UiState.Success(false)
    }
}