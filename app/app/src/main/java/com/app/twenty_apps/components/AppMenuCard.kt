package com.app.twenty_apps.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.twenty_apps.utils.morganite
import com.app.twenty_apps.utils.openSauce
import kotlinx.coroutines.delay

@Composable
fun AppMenuCard(title: String, description: String, number: String, onClick: () -> Unit) {
  var isPressed by remember { mutableStateOf(false) }
  var isClickable by remember { mutableStateOf(true) }
  val scale by animateFloatAsState(
    targetValue = if (isPressed) 0.95f else 1f,
    animationSpec = tween(durationMillis = 200)
  )

  Box(
    modifier = Modifier
      .scale(scale)
      .fillMaxWidth()
      .height(180.dp)
      .background(Color(0xff171717), shape = RoundedCornerShape(15.dp))
      .padding(10.dp)
      .pointerInput(Unit) {
        detectTapGestures(
          onPress = {
            if(isClickable){
              isPressed = true
              tryAwaitRelease()
              isPressed = false
              onClick()
              isClickable = false
            }
          }
        )
      }
  ) {
    Text(
      text = number,
      fontSize = 250.sp,
      color = Color.White.copy(0.05f),
      fontFamily = morganite,
      fontWeight = FontWeight.ExtraBold,
      modifier = Modifier.align(Alignment.CenterStart)
    )
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      modifier = Modifier.fillMaxSize()
    ) {
      Text(
        title,
        color = Color.White,
        fontSize = 40.sp,
        fontFamily = openSauce,
        fontWeight = FontWeight.Bold
      )
      Text(
        description,
        color = Color(0xff808080),
        fontSize = 15.sp,
        fontFamily = openSauce,
        fontWeight = FontWeight.Normal
      )
    }
  }
  LaunchedEffect (isClickable ){
    delay(500)
    isClickable = true
  }
}
