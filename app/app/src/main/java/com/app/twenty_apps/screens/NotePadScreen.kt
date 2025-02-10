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
import androidx.navigation.NavController

@Composable
fun NotePadScreen(navController: NavController) {
  var textState by remember { mutableStateOf(TextFieldValue("")) }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .statusBarsPadding()
      .background(Color.White)
      .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    BasicTextField(
      value = textState,
      onValueChange = { textState = it },
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
        .background(Color.LightGray)
        .padding(8.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = { textState = TextFieldValue("") }) {
      Text("Clear")
    }
  }
}
