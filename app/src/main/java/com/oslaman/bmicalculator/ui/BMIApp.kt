package com.oslaman.bmicalculator.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.oslaman.bmicalculator.ui.calculator.CalculatorScreen
import com.oslaman.bmicalculator.ui.result.ResultScreen

@Composable
fun BMIApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.CALCULATOR
    ) {
        composable(Route.CALCULATOR) { backStackEntry ->
            CalculatorScreen(
                onResultClick = { result ->
                    if (backStackEntry.lifecycle.currentState == Lifecycle.State.RESUMED) {
                        navController.navigate("${Route.RESULT}/$result")
                    }
                }
            )
        }
        composable(
            route = "${Route.RESULT}/${Argument.RESULT}",
            arguments = listOf(
                navArgument(Argument.RESULT) {
                    type = NavType.StringType
                }
            ),
        ){
            ResultScreen()
        }
    }
}

object Route {
    const val CALCULATOR = "calculator"
    const val RESULT = "result"
}

object Argument {
    const val RESULT = "result"
}