package com.sproutify.sproutify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.sproutify.auth.navigation.AuthBaseRoute
import com.sproutify.auth.navigation.authSection
import com.sproutify.auth.navigation.navigateToSignIn
import com.sproutify.auth.navigation.navigateToSignUp
import com.sproutify.feed.navigation.feedSection
import com.sproutify.feed.navigation.navigateToFeed

@Composable
fun SprtNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AuthBaseRoute,
        modifier = modifier
    ) {
        authSection(
            onSignInClicked = navController::navigateToSignIn,
            onSignUpClicked = navController::navigateToSignUp,
            navigateToFeed = navController::navigateToFeed
        )
        feedSection(

        )
    }

}