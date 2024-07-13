package com.sathish.codeassignment.presentation.ui.route

/**
 * Created by sathish on 11,July,2024
 */
sealed class Screens(private val route:String, private val args:List<String>?=null) {

    data object Login : Screens("login")
    data object Home : Screens("home", listOf("name"))
    data object Detail : Screens("detail", listOf("name","dose","strength"))

    operator fun invoke(): String {
        val argList = StringBuilder()
        args?.forEach {
            argList.append("/{$it}")
        }
        return route+argList
    }

    fun withArgs(vararg args: String): String {
      return buildString {
          append(route)
          args.forEach {
              append("/$it")
          }
      }
    }

}