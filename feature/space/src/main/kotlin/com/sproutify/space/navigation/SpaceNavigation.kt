package com.sproutify.space.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sproutify.space.SpaceScreen


fun NavGraphBuilder.spaceSection(
    modifier: Modifier = Modifier,

) {
    composable<SpaceRoute> { entry ->
        val route = entry.toRoute<SpaceRoute>()

        SpaceScreen(
            modifier = modifier,
            spaceId = route.spaceId,
            spaceName = route.spaceName
        )
    }
}