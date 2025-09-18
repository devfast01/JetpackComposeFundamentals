package com.example.ComposeUiProject.Domain

import java.io.Serializable


data class MainItems(
    val title: String = "",
    val pic: String = "",
    val onCardClick: () -> Unit = {},
) : Serializable
