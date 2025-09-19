package com.example.jetpackcomposefundamentals.MultipleBackStacks1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposefundamentals.R

class MultiBackStack1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val rootNavController = rememberNavController()
            val navBackStackEntry by rootNavController.currentBackStackEntryAsState()

            Scaffold(
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            val isSelected =
                                item.title.lowercase() == navBackStackEntry?.destination?.route
                            NavigationBarItem(
                                selected = isSelected,
                                label = {
                                    Text(text = item.title)
                                }, icon = {
                                    Icon(
                                        imageVector = if (isSelected) {
                                            item.selectedIcon
                                        } else {
                                            item.unselectedIcon
                                        }, contentDescription = null
                                    )
                                }, onClick = {
                                    rootNavController.navigate(item.title.lowercase()) {
                                        popUpTo(rootNavController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            ) { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    NavHost(rootNavController, startDestination = "home1") {
                        composable("home1") {
                            HomeNavHost()
                        }
                        composable("chat1") {
                            ChatNavHost()
                        }
                        composable("settings1") {
                            SettingsNavHost()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home1") {
        for (i in 1..10) {
            composable("home$i") {
                GenericScreen(title = "Home $i", onNextClick = {
                    if (i < 10) navController.navigate("home${i + 1}")
                })
            }
        }
    }
}

@Composable
fun ChatNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "chat1") {
        for (i in 1..10) {
            composable("chat$i") {
                GenericScreen(title = "Chat $i", onNextClick = {
                    if (i < 10) navController.navigate("chat${i + 1}")
                })
            }
        }
    }
}

@Composable
fun SettingsNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "settings1") {
        for (i in 1..10) {
            composable("settings$i") {
                GenericScreen(title = "Settings $i", onNextClick = {
                    if (i < 10) navController.navigate("settings${i + 1}")
                })
            }
        }
    }
}


@Composable
fun GenericScreen(
    title: String,
    onNextClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = title)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNextClick) {
            Text(
                text = "Next"
            )
        }
    }

}


data class BottomNavigationItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
)

val items = listOf(
    BottomNavigationItem(
        title = "Home",
        unselectedIcon = Icons.Filled.Home,
        selectedIcon = Icons.Outlined.Home,
    ),
    BottomNavigationItem(
        title = "Chat",
        unselectedIcon = Icons.Filled.Email,
        selectedIcon = Icons.Outlined.Email,
    ),
    BottomNavigationItem(
        title = "Settings",
        unselectedIcon = Icons.Filled.Settings,
        selectedIcon = Icons.Outlined.Settings,
    )

)