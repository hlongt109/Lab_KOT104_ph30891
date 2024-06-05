package com.ph30891.qlsv_roomdb_ph30891

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ph30891.qlsv_roomdb_ph30891.ui.theme.QLSV_ROOMDB_ph30891Theme
import com.ph30891.qlsv_roomdb_ph30891.view.navigator.ScreenNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QLSV_ROOMDB_ph30891Theme {
               ScreenNavigation()
            }
        }
    }
}
