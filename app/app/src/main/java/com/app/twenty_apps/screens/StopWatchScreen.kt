package com.app.twenty_apps.screens

import android.os.SystemClock
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun StopWatchScreen(navController: NavController) {
  var time by remember { mutableStateOf(0L) }
  var isRunning by remember { mutableStateOf(false) }
  var startTime by remember { mutableStateOf(0L) }

  LaunchedEffect(isRunning) {
    if (isRunning) {
      startTime = SystemClock.elapsedRealtime() - time
      while (isRunning) {
        time = SystemClock.elapsedRealtime() - startTime
        delay(10L)
      }
    }
  }

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Black),
    contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text(
        text = formatTime(time),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
      )
      Spacer(modifier = Modifier.height(20.dp))
      Row {
        Button(onClick = { isRunning = !isRunning }) {
          Text(if (isRunning) "Pause" else "Start")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(onClick = {
          isRunning = false
          time = 0L
        }) {
          Text("Reset")
        }
      }
    }
  }
}

private fun formatTime(timeMillis: Long): String {
  val seconds = (timeMillis / 1000) % 60
  val minutes = (timeMillis / 60000) % 60
  val milliseconds = (timeMillis % 1000) / 10
  return "%02d:%02d:%02d".format(minutes, seconds, milliseconds)
}
