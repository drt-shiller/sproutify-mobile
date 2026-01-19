package com.sproutify.space.dashboard

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sproutify.designsystem.theme.SprtTheme

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    viewModel: DashboardViewModel = hiltViewModel()
) {
    Scaffold(topBar = topBar,
        containerColor = SprtTheme.colors.surface,
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
       LazyColumn(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

       }
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    SprtTheme {
        DashboardScreen()
    }
}