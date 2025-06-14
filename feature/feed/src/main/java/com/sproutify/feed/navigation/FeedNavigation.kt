package com.sproutify.feed.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
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

fun NavGraphBuilder.feedSection() {
    navigation<FeedBaseRoute>(startDestination = FeedRoute){
        composable<FeedRoute> {
            YourFeedScreen()
        }
    }
}