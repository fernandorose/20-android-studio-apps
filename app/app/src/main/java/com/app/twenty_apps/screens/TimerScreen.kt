package com.app.twenty_apps.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun TimerScreen(navController: NavController) {
  var timeInput by remember { mutableStateOf(TextFieldValue("60")) }
  var time by remember { mutableStateOf(60000L) }
  var isRunning by remember { mutableStateOf(false) }

  LaunchedEffect(isRunning) {
    while (isRunning && time > 0) {
      delay(1000L)
      time -= 1000L
    }
  }

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Black),
    contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      BasicTextField(
        value = timeInput,
        onValueChange = { timeInput = it },
        modifier = Modifier
          .background(Color.White)
          .padding(8.dp)
      )
      Spacer(modifier = Modifier.height(10.dp))
      Button(onClick = {
        time = timeInput.text.toLongOrNull()?.times(1000) ?: 60000L
      }) {
        Text("Set Time")
      }
      Spacer(modifier = Modifier.height(10.dp))
      Text(
        text = formatTime(time),
        fontSize = 40.sp,
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
          time = timeInput.text.toLongOrNull()?.times(1000) ?: 60000L
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
  return "%02d:%02d".format(minutes, seconds)
}
