package com.app.twenty_apps.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.twenty_apps.screens.StopWatchScreen
import com.app.twenty_apps.screens.LanternScreen
import com.app.twenty_apps.screens.MenuScreen

@Composable
fun AppNavigation() {
  val navController = rememberNavController()

  NavHost(navController = navController, startDestination = "MenuScreen"){
    composable("MenuScreen") { MenuScreen(navController) }
    composable("LanternScreen") { LanternScreen(navController) }
    composable("StopWatchScreen") { StopWatchScreen(navController)  }
  }
}