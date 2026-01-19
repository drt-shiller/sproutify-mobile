package com.sproutify.sproutify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sproutify.auth.navigation.AuthBaseRoute
import com.sproutify.auth.navigation.authSection
import com.sproutify.auth.navigation.navigateToSignIn
import com.sproutify.auth.navigation.navigateToSignUp
import com.sproutify.feed.navigation.feedSection
import com.sproutify.feed.navigation.navigateToFeed
import com.sproutify.space.navigation.navigateToSpace
import com.sproutify.space.navigation.spaceSection

@Composable
fun SprtNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AuthBaseRoute,
    ) {
        authSection(
            modifier = modifier,
            onSignInClicked = navController::navigateToSignIn,
            onSignUpClicked = navController::navigateToSignUp,
            navigateToFeed = navController::navigateToFeed
        )
        feedSection(
            modifier = modifier,
            onSpaceClick = navController::navigateToSpace
        )
        // We don't want to pass the inner padding down as the Space Section has an internal
        // scaffold
        spaceSection()
    }

}