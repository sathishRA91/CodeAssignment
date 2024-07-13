package com.sathish.codeassignment.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.sathish.codeassignment.presentation.ui.UiState
import com.sathish.codeassignment.presentation.ui.route.Screens

/**
 * Created by sathish on 11,July,2024
 */

@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel = viewModel()) {
    val loginState by remember { loginViewModel.getLoginState }.collectAsStateWithLifecycle()
    val uiState by remember { loginViewModel.uiState }.collectAsStateWithLifecycle()
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
            .background(Color.White)
    ) {

        Text(
            text = "Code Test", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.Black,
            modifier = Modifier.padding(15.dp)
        )

        OutlinedTextField(
            value = loginState.userName, onValueChange = {
                loginViewModel.userNameChange(it)
            }, isError = loginState.userNameError != null,
            modifier = Modifier
                .padding(10.dp, 5.dp, 10.dp)
                .height(IntrinsicSize.Min)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            label = {
                Text(text = "User Name")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Password
            )
        )
        loginState.userNameError?.let {
            Text(
                text = it, color = MaterialTheme.colorScheme.error,
                fontSize = 11.sp, modifier = Modifier
                    .align(Alignment.Start)
                    .padding(10.dp, 0.dp, 0.dp, 0.dp)
            )
        }

        OutlinedTextField(
            value = loginState.password, onValueChange = {
                loginViewModel.passwordChange(it)
            },
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .height(IntrinsicSize.Min)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            )
        )

        OutlinedButton(
            onClick = {
                loginViewModel.onLoginClicked()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(45.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(text = "Login")
        }
    }

    LaunchedEffect(uiState) {
        if (uiState is UiState.Success)
        {
            if(uiState.data==true)
            {
                keyboardController?.hide()
                loginViewModel.ResetState()
                navController.navigate(Screens.Home.withArgs(loginState.userName)){
                    popUpTo(Screens.Login()){inclusive = true}
                }
            }
        }
    }



}

