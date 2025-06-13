package com.sproutify.sproutify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sproutify.auth.landing.LandingScreen
import com.sproutify.designsystem.theme.SprtTheme

class MainActivity : ComponentActivity() {
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