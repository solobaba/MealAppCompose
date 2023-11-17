package com.example.coreuiimpl.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.coreuiimpl.screen.MealDetailsScreen
import com.example.coreuiimpl.screen.MealsCategoriesScreen
import com.example.coreuiimpl.viewmodel.MealDetailsViewModel

@Composable
fun FoodiezApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "destination_meals_list") {
        composable("destination_meals_list") {
            MealsCategoriesScreen() { navigationMealId ->
                navController.navigate("destination_meal_details/$navigationMealId")
            }
        }
        composable(route = "destination_meal_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val viewModel : MealDetailsViewModel = viewModel()
            MealDetailsScreen(viewModel.mealState.value)
        }
    }
}