package com.example.thirtydaysoffitness.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = primaryD,
    surface = surfaceD,
    background = backgroundD,
    secondary = secondaryD,
    onSurface = onSurfaceD,
    onPrimary = onPrimaryD
)

private val LightColorPalette = lightColors(
    primary = primaryL,
    surface = surfaceL,
    background = backgroundL,
    secondary = secondaryL,
    onSurface = onSurfaceL,
    onPrimary = onPrimaryL
)

@Composable
fun ThirtyDaysOfFitnessTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}