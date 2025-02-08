package com.app.twenty_apps.screens

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.twenty_apps.utils.ChangeStatusBarColor

@Composable
fun LanternScreen(navController: NavController) {
  var isFlashOn by remember { mutableStateOf(false) } // Estado para saber si la linterna está encendida
  val context = LocalContext.current

  fun toggleFlashlight() {
    val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    val cameraId = cameraManager.cameraIdList.firstOrNull()

    if (cameraId != null) {
      try {
        if (isFlashOn) {
          // Apagar la linterna
          cameraManager.setTorchMode(cameraId, false)
        } else {
          // Encender la linterna
          cameraManager.setTorchMode(cameraId, true)
        }
        isFlashOn = !isFlashOn
      } catch (e: CameraAccessException) {
        Toast.makeText(context, "Error al acceder a la cámara", Toast.LENGTH_SHORT).show()
      }
    } else {
      Toast.makeText(context, "No se encontró una cámara con flash", Toast.LENGTH_SHORT).show()
    }
  }

  ChangeStatusBarColor(
    statusBarColor = Color.Black,
    navigationBarColor = Color.Black,
    isLightIcons = true
  )
  Box(
    modifier = Modifier
      .fillMaxSize()
      .statusBarsPadding()
      .background(Color.Black)
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = if (isFlashOn) "Linterna encendida" else "Linterna apagada",
      )

      Spacer(modifier = Modifier.height(20.dp))

      Button(
        onClick = { toggleFlashlight() },
        modifier = Modifier.padding(16.dp)
      ) {
        Text(text = if (isFlashOn) "Apagar linterna" else "Encender linterna")
      }
    }
  }
}