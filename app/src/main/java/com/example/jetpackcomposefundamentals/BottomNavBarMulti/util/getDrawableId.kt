package com.example.ComposeUiProject.HomeApp.util

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


@SuppressLint("LocalContextResourcesRead")
@Composable
fun getDrawableId(name: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(name, "drawable", context.packageName)
}