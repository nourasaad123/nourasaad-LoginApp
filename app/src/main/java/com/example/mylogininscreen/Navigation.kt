package com.example.mylogininscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
        fun Nav(){
       val navController=rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable(route="login"){
            LogininScreen(navController)
        }
        composable(route="signup"){
            Greeting(navController)
        }
        composable(route="profilescreen/{fname}&{lname}&{age}&{email}",
            arguments = listOf(
                navArgument("fname"){
                    type=NavType.StringType
                },
                        navArgument("lname"){
                    type=NavType.StringType
                } ,
                navArgument("age"){
                    type=NavType.IntType
                } , navArgument("email"){
                    type=NavType.StringType
                })){navBackStackEntry->
            val fname:String=navBackStackEntry.arguments?.getString("fname")?:"NOName"
            val lname:String=navBackStackEntry.arguments?.getString("lname")?:"NOName"
            val age:Int=navBackStackEntry.arguments?.getInt("age")?:0
            val email:String=navBackStackEntry.arguments?.getString("email")?:"NOName"
            NavigateParameter(navController,fname,lname,age,email)
        }
    }
        }