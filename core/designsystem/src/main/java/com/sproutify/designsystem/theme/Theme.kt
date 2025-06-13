package com.sproutify.designsystem.theme

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

/**
 * Light default theme color scheme
 */

@VisibleForTesting
val LightDefaultColorScheme = lightColorScheme(
    primary = SproutGreen60,
    onPrimary = Neutral10,
    primaryContainer = Slate40,
    onPrimaryContainer = Neutral10,
    secondary = EmberOrange60,
    onSecondary = Neutral10,
    secondaryContainer = Peach80,
    onSecondaryContainer = Brown50,
    error = Red40,
    onError = Neutral10,
    background = Gray50,
    surface = Neutral10,
    onSurface = Neutral90,
    surfaceVariant = Teal50,
    inverseSurface = Neutral90,
    outline = Neutral40,
)

/**
 * TODO: Handle Dark Theme
 */
@Composable
fun SprtTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = LightDefaultColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = SprtTypography,
        content = content
    )
}

object SprtTheme {
    val padding: Padding = SprtPadding

    val colors: ColorScheme
        @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme

    val typography: Typography
        @Composable @ReadOnlyComposable get() = MaterialTheme.typography
}