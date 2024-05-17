package com.ph30891.bai5_ph30891.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ph30891.bai5_ph30891.Navigator.MainScreen
import com.ph30891.bai5_ph30891.ui.theme.Bai5_ph30891Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bai5_ph30891Theme {
                MainScreen()
            }
        }
    }
}