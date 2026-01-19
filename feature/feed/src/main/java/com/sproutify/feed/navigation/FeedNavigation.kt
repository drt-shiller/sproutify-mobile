package com.sproutify.feed.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sproutify.feed.YourFeedScreen
import kotlinx.serialization.Serializable

@Serializable
data object FeedBaseRoute

@Serializable
data object FeedRoute

fun NavController.navigateToFeed(navOptions: NavOptionsBuilder.() -> Unit = {} ) {
    navigate(route = FeedRoute) {
        navOptions()
    }
}

fun NavGraphBuilder.feedSection(
    modifier: Modifier = Modifier,
    onSpaceClick: (String, String) -> Unit,
) {
    navigation<FeedBaseRoute>(startDestination = FeedRoute){
        composable<FeedRoute> {
            YourFeedScreen(
                modifier = modifier,
                onSpaceClick = onSpaceClick
            )
        }
    }
}