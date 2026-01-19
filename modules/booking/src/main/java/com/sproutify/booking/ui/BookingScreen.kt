package com.sproutify.booking.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sproutify.designsystem.theme.SprtTheme

@Composable
fun BookingScreen(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {}
) {
    Scaffold(topBar = topBar) { innerPadding ->
        Box(modifier = modifier.fillMaxSize().padding(innerPadding)) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Booking Module"
            )
        }
    }
}

@Preview
@Composable
private fun BookingScreenPreview() {
    SprtTheme {
        BookingScreen()
    }
}