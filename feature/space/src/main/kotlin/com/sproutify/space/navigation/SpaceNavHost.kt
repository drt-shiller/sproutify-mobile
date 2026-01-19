package com.sproutify.space.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sproutify.space.dashboard.DashboardScreen
import com.sproutify.space.dashboard.DashboardViewModel
import kotlinx.serialization.Serializable

@Serializable
data class SpaceRoute(
    val spaceId: String,
    val spaceName: String,
)

@Serializable
data object DashboardRoute

fun NavController.navigateToSpace(
    spaceId: String,
    spaceName: String,
    navOptions: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(route = SpaceRoute(spaceId = spaceId, spaceName = spaceName)) {
        navOptions()
    }
}

@Composable
fun SpaceNavHost(
    modifier: Modifier,
    startDestination: Any,
    spaceId: String,
    topBar: @Composable () -> Unit = {},
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable<DashboardRoute> {
            DashboardScreen(
                topBar = topBar,
                viewModel = hiltViewModel<DashboardViewModel, DashboardViewModel.Factory>(key = spaceId) { factory ->
                    factory.create(spaceId)
                }
            )
        }
        moduleNavGraph()
    }
}