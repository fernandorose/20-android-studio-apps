package com.app.twenty_apps.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.twenty_apps.R
import com.app.twenty_apps.components.AppMenuCard
import com.app.twenty_apps.utils.ChangeStatusBarColor
import com.app.twenty_apps.utils.morganite
import com.app.twenty_apps.utils.openSauce


@Preview(showBackground = true)
@Composable
fun MenuScreen(navController: NavController) {
  ChangeStatusBarColor(
    statusBarColor = Color.Black,
    navigationBarColor = Color.Black,
    isLightIcons = true
  )
  Column(
    modifier = Modifier
      .fillMaxSize()
      .statusBarsPadding()
      .background(Color.Black)
  ) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(10.dp),
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ) {
      Image(
        painter = painterResource(R.drawable.logo_black),
        "Logo",
        modifier = Modifier.width(50.dp)
      )
      Text(
        "20 apps in 1",
        fontSize = 80.sp,
        fontFamily = morganite,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White
      )
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
          Text("Built with", fontFamily = openSauce, color = Color(0xffbebebe), fontSize = 10.sp)
        }
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
          Text("Kotlin", fontFamily = openSauce, color = Color(0xff808080))
          Image(
            painter = painterResource(R.drawable.kotlin),
            "kotlin",
            modifier = Modifier.width(15.dp)
          )
          Text(" + Jetpack Compose", fontFamily = openSauce, color = Color(0xff808080))
          Image(
            painter = painterResource(R.drawable.jetpack),
            "jetpack",
            modifier = Modifier.width(20.dp)
          )
        }
      }
    }
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .verticalScroll(state = rememberScrollState()),
      verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      AppMenuCard(
        number = "1",
        title = "Calculator 🧠",
        description = "Simple calculator",
        onClick = {})
      AppMenuCard(
        number = "2",
        title = "StopWatch ⌚",
        description = "Simple StopWatch app",
        onClick = {navController.navigate("StopWatchScreen")})
      AppMenuCard(
        number = "3",
        title = "NotePad 📝",
        description = "Simple notepad app",
        onClick = {})
      AppMenuCard(
        number = "4",
        title = "To-Do list 📃",
        description = "Simple to-do list app",
        onClick = {})
      AppMenuCard(number = "5", title = "Timer ⌚", description = "Simple timer app", onClick = {})
      AppMenuCard(
        number = "6",
        title = "Unit converter 🧪",
        description = "Simple unit converter app",
        onClick = {})
      AppMenuCard(
        number = "7",
        title = "Lantern 🔦",
        description = "Simple lantern app",
        onClick = { navController.navigate("LanternScreen") })
    }
  }
}