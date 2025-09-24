package com.example.jetpackcomposefundamentals.SimpleSharedElement

import android.R.attr.type
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposefundamentals.R
import com.example.jetpackcomposefundamentals.ui.theme.JetpackComposeFundamentalsTheme

class SimpleSharedElementActivity : ComponentActivity() {
    @SuppressLint("UnusedSharedTransitionModifierParameter")
    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeFundamentalsTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SharedTransitionLayout {
                        val navController = rememberNavController()
                        NavHost(navController, startDestination = "list") {
                            composable("list") {
                                ListScreen(
                                    onItemClick = { resId, text ->
                                        navController.navigate("detail/$resId/$text")
                                    },
                                    animatedVisibilityScope = this
                                )
                            }

                            composable(
                                "detail/{resId}/{text}", arguments =
                                    listOf(
                                        navArgument("resId") { type = NavType.IntType },
                                        navArgument("text") { type = NavType.StringType }
                                    )
                            ) { backStackEntry ->
                                val resId = backStackEntry.arguments?.getInt("resId") ?: 0
                                val text = backStackEntry.arguments?.getString("text") ?: ""
                                DetailScreen(
                                    resId = resId,
                                    text = text,
                                    animatedVisibilityScope = this
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}