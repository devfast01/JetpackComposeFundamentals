package com.example.ComposeUiProject.HomeApp.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ComposeUiProject.HomeApp.core.model.PropertyHome
import com.example.ComposeUiProject.HomeApp.feature.components.CategoriesRow
import com.example.ComposeUiProject.HomeApp.feature.components.HeaderSection
import com.example.ComposeUiProject.HomeApp.feature.components.PropertyCard
import com.example.ComposeUiProject.HomeApp.feature.components.SearchRow
import com.example.jetpackcomposefundamentals.BottomNavBarMulti.feature.homeDetails.HomeDetailsScreen
import com.example.jetpackcomposefundamentals.MultipleBackStacks1.HomeScreen1
import com.example.jetpackcomposefundamentals.MultipleBackStacks1.HomeScreen2
import com.example.jetpackcomposefundamentals.R
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.net.URLEncoder


@Composable
fun HomeScreenNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home1") {
        composable("home1") {
            HomeMainScreen(onClickOpenCatDetails = {
                navController.navigate("home2")
            }, onClickOpenHomeDetails = { property ->
                val json = Json.encodeToString(property)
                val encodedJson = URLEncoder.encode(json, "UTF-8")
                navController.navigate("home_details_screen/$encodedJson")
            })
        }

        composable("home2") {
            HomeScreen2(onNextClick = {})
        }

        composable(
            route = "home_details_screen/{propertyJson}",
            arguments = listOf(navArgument("propertyJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val encodedJson = backStackEntry.arguments?.getString("propertyJson") ?: ""
            val property = try {
                val json = URLDecoder.decode(encodedJson, "UTF-8") // Add decoding
                Json.decodeFromString<PropertyHome>(json)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }


            HomeDetailsScreen(
                title = property?.title ?: "",
                description = property?.description ?: "",
                picPath = property?.pickPath ?: "",
            )
        }
    }
}

@Composable
@Preview
fun HomeMainScreen(
    onClickOpenCatDetails: () -> Unit = {},
    onClickOpenHomeDetails: (PropertyHome) -> Unit = {},
) {
    val items = remember {
        sampleProperties()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(colorResource(R.color.lightGreyHome)),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item {
            HeaderSection()
        }
        item {
            Spacer(Modifier.height(16.dp))
        }
        item { SearchRow() }
        item {
            Spacer(Modifier.height(16.dp))
        }
        item {
            CategoriesRow(onClickOpenCatDetails)
        }
        item {
            Spacer(Modifier.height(8.dp))
        }
        items(items) { property ->
            PropertyCard(property, onClickOpenHomeDetails)
        }

        item {
            Spacer(Modifier.height(16.dp))
        }
    }

}