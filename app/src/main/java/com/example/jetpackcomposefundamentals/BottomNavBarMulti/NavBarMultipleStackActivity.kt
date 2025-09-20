package com.example.jetpackcomposefundamentals.BottomNavBarMulti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpackcomposefundamentals.ui.theme.JetpackComposeFundamentalsTheme

class NavBarMultipleStackActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeFundamentalsTheme {

            }
        }
    }
}