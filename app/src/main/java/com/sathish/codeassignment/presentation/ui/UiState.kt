package com.sathish.codeassignment.presentation.ui

/**
 * Created by sathish on 12,July,2024
 */
sealed class UiState<out T>(val data: T? = null, val message: String? = null) {
    class Idle<T>() : UiState<T>()
    class Success<T>(data: T? = null) : UiState<T>(data)
    class ErrorMessage<T>(message: String?, data: T? = null) : UiState<T>(data, message)
    class Loading<T>() : UiState<T>()
}
