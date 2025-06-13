package com.sproutify.sproutify.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sproutify.sproutify.navigation.SprtNavHost

@Composable
fun SprtApp() {
    val navController = rememberNavController()
    Scaffold { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            SprtNavHost(
                navController = navController
            )
        }
    }
}