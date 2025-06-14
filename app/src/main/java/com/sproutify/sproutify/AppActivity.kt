package com.sproutify.sproutify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sproutify.designsystem.theme.SprtTheme
import com.sproutify.sproutify.ui.SprtApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SprtTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LandingScreen(
                        modifier = Modifier.padding(innerPadding),
                        onSignUpClicked = {},
                        onSignInClicked = {}
                    )
                }
            }
        }
    }
}