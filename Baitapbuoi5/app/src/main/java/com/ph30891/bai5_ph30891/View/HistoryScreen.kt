package com.ph30891.bai5_ph30891.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HistoryScreen(){
  Box(
      modifier = Modifier
          .fillMaxSize()
          .background(Color.White),
      contentAlignment = Alignment.Center
  ){
      Text(
          text = "History",
          fontSize = MaterialTheme.typography.h3.fontSize,
          fontWeight = FontWeight.Bold,
          color = Color.Black
      )
  }
}
@Composable
@Preview
fun HistoryScreenPreview(){
    HistoryScreen()
}