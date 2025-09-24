package com.example.jetpackcomposefundamentals.SharedElementTransition.navigation

import kotlinx.serialization.Serializable

@Serializable object Home
@Serializable data class Detail(
    val imageIdArg: Int = 1
)