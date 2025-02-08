package com.app.twenty_apps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import com.app.twenty_apps.screens.MenuScreen
import com.app.twenty_apps.utils.AppNavigation
import com.app.twenty_apps.utils.ChangeStatusBarColor

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      AppNavigation()
    }
  }
}