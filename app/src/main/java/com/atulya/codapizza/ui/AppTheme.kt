package com.atulya.codapizza.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppTheme(
    content: @Composable () -> Unit
){

    val adaptiveColors = if(isSystemInDarkTheme()) {
        darkColors(
            primary = Color(0xFFB72A33),
            primaryVariant = Color(0xFFA6262E),
            secondary = Color(0xFF03C4DD),
            secondaryVariant = Color(0xFF03B2C9),
        )
    }else {
        lightColors(
            primary = Color(0xFFB72A33),
            primaryVariant = Color(0xFFA6262E),
            secondary = Color(0xFF03C4DD),
            secondaryVariant = Color(0xFF03B2C9),
        )
    }
    MaterialTheme(
        colors = adaptiveColors
    ) {
        content()
    }
}