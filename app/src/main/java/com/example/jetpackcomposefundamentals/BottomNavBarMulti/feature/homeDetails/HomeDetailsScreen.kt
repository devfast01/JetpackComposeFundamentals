package com.example.jetpackcomposefundamentals.BottomNavBarMulti.feature.homeDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposefundamentals.BottomNavBarMulti.feature.homeDetails.components.MainImage
import com.example.jetpackcomposefundamentals.R

@Composable
fun HomeDetailsScreen(
    title: String = "",
    description: String = "",
    picPath: String = "",
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .background(colorResource(R.color.lightGreyHome))
        ) {
            item {
                MainImage(title, description, picPath)
            }
        }
    }
}

@Preview
@Composable
fun HomeDetailsScreenPreview() {
    HomeDetailsScreen(
        title = "Modern Apartment",
        description = "123 Main St, Anytown, USA",
        picPath = "pic_1",
    )
}
