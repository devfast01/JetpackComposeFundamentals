package com.example.jetpackcomposefundamentals.SharedElementTransition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposefundamentals.ui.theme.JetpackComposeFundamentalsTheme
import com.example.jetpackcomposefundamentals.SharedElementTransition.navigation.NavGraph

class SharedElementActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeFundamentalsTheme {
                val navController = rememberNavController()
                Box(modifier = Modifier.padding(top = 7.dp)){
                    NavGraph(navController = navController)
                }
            }
        }
    }
}
