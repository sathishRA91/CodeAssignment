package com.sathish.codeassignment.presentation.ui.route

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sathish.codeassignment.presentation.detail.DetailScreen
import com.sathish.codeassignment.presentation.home.HomeScreen
import com.sathish.codeassignment.presentation.login.LoginScreen

/**
 * Created by sathish on 12,July,2024
 */

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Login())
    {
        composable(route = Screens.Login())
        {
            LoginScreen(navController)
        }
        composable(route = Screens.Home(),
            arguments = listOf(navArgument("name"){
                NavType.StringType
            }))
        {
            HomeScreen(navController,it.arguments?.getString("name")?:"")
        }
        composable(route = Screens.Detail(),
            arguments = listOf(navArgument("name"){
                NavType.StringType
            },
                navArgument("dose"){
                    NavType.StringType
                },
                navArgument("strength"){
                    NavType.StringType
                })

        )
        {
            val name = it.arguments?.getString("name")?:""
            val dose = it.arguments?.getString("dose")?:""
            val strength = it.arguments?.getString("strength")?:""
            DetailScreen(navController,name,dose,strength)
        }

    }
}