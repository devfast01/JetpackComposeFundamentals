package com.example.jetpackcomposefundamentals.SharedElementTransition_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposefundamentals.SharedElementTransition_1.details.DetailsScreen
import com.example.jetpackcomposefundamentals.SharedElementTransition_1.listing.ListingScreen
import com.example.jetpackcomposefundamentals.ui.theme.JetpackComposeFundamentalsTheme

class SharedElementTransitionActivity_1 : ComponentActivity() {
    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeFundamentalsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    SharedTransitionLayout {
                        NavHost(
                            navController = navController,
                            startDestination = "list"
                        ) {
                            composable("list") {
                                ListingScreen(
                                    onItemClick = { productId ->
                                        navController.navigate("detail/${productId}")
                                    },
                                    sharedTransitionScope = this@SharedTransitionLayout,
                                    animatedVisibilityScope = this@composable,
                                )
                            }
                            composable(
                                route = "detail/{productId}",
                                arguments = listOf(
                                    navArgument("productId") {
                                        type = NavType.IntType
                                    },
                                )
                            ) {
                                val productId = it.arguments?.getInt("productId") ?: 0

                                DetailsScreen(
                                    productId = productId,
                                    sharedTransitionScope = this@SharedTransitionLayout,
                                    animatedVisibilityScope = this@composable,
                                    onBackButtonClicked = {
                                        navController.navigate("list")
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

