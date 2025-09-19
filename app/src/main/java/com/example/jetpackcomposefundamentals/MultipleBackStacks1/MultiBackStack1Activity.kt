package com.example.jetpackcomposefundamentals.MultipleBackStacks1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
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
            ) { }
        }
    }
}

@Composable
fun HomeNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        for (i in 1..10) {
            composable("home$i") {

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

    ) { }

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