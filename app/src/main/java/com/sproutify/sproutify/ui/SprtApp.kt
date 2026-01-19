package com.sproutify.sproutify.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sproutify.designsystem.theme.SprtTheme
import com.sproutify.sproutify.navigation.SprtNavHost

@Composable
fun SprtApp() {
    val navController = rememberNavController()
    Scaffold(
        containerColor = SprtTheme.colors.surface
    ) { padding ->
        SprtNavHost(
            modifier = Modifier.padding(padding),
            navController = navController
        )
    }
}