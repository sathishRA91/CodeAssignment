package com.sathish.codeassignment.presentation.login

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by sathish on 12,July,2024
 */
class LoginViewModelTest
{

    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp()
    {
        loginViewModel = LoginViewModel()
    }

    @Test
    fun `empty userName return false`()
    {
        loginViewModel.userNameChange("")

        val result = loginViewModel.validateInput()

        Assert.assertFalse(result)
    }

    @Test
    fun `valid userName return true`()
    {
        loginViewModel.userNameChange("Sathish")

        val result = loginViewModel.validateInput()

        Assert.assertTrue(result)
    }
}