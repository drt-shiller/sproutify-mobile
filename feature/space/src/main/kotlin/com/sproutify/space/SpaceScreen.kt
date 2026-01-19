package com.sproutify.space

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sproutify.designsystem.theme.SprtTheme
import com.sproutify.module.model.ModuleRoute
import com.sproutify.space.dashboard.DashboardScreen
import com.sproutify.space.dashboard.DashboardViewModel
import com.sproutify.space.navigation.DashboardRoute
import com.sproutify.space.navigation.SpaceNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceScreen(
    modifier: Modifier = Modifier,
    spaceId: String,
    spaceName: String,
    viewModel: SpaceViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val startDestination = DashboardRoute
    var selectedDestination by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets(0.dp),
        containerColor = SprtTheme.colors.surface,
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                state.forEachIndexed { index, destination ->
                    val route = destination as ModuleRoute<Any>
                    NavigationBarItem(
                        selected = selectedDestination == index,
                        onClick = {
                            navController.navigate(route = route.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = false
                                }
                                launchSingleTop
                            }
                            selectedDestination = index
                        },
                        label = {
                            Text(destination.name)
                        },
                        icon = {
                            Icon(Icons.Default.Edit, contentDescription = "")
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        SpaceNavHost(
            modifier = Modifier.padding(innerPadding),
            topBar = {
                Column {
                    TopAppBar(title = { Text(spaceName) })
                    HorizontalDivider(color = SprtTheme.colors.outline)
                }
            },
            startDestination = startDestination,
            navController = navController,
            spaceId = spaceId,
        )
    }
}

@Preview
@Composable
private fun SpaceScreenPreview() {
    SprtTheme {
        SpaceScreen(
            spaceId = "",
            spaceName = "",
        )
    }
}