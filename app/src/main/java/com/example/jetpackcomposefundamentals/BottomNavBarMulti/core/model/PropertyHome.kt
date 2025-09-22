package com.example.ComposeUiProject.HomeApp.core.model

data class PropertyHome(
    val type: String,
    val title: String,
    val address: String,
    val pickPath: String,
    val price: Int,
    val bed: Int,
    val bath: Int,
    val size: Int,
    val isGarage: Boolean,
    val score: Double,
    val description: String
)
