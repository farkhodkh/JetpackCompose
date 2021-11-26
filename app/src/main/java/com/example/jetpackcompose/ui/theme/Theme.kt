package com.example.jetpackcompose.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun ApplicationTheme(content: @Composable () -> Unit) {
    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setNavigationBarColor(Color.White)
    }
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

private val LightColorPalette = lightColors(
    primary = CongressBlue500,
    primaryVariant = CongressBlue400,
    secondary = TallPoppy500,
    secondaryVariant = CongressBlue500,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onSurface = Color.Black,
    onBackground = Color.Black
)

internal val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(12.dp)
)