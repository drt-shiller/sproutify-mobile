package com.sproutify.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sproutify.designsystem.theme.SprtTheme

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Sign In Screen"
        )
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    SprtTheme {
        SignInScreen()
    }
}