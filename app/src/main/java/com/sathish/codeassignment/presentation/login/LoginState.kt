package com.sathish.codeassignment.presentation.login

/**
 * Created by sathish on 12,July,2024
 */
data class LoginState(
    val userName: String = "",
    val password: String = "",
    val userNameError:String?=null
) {
}