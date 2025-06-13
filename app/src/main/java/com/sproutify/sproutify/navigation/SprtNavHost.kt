package com.sproutify.sproutify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.sproutify.auth.navigation.LandingRoute
import com.sproutify.auth.navigation.authSection
import com.sproutify.auth.navigation.navigateToSignIn
import com.sproutify.auth.navigation.navigateToSignUp

@Composable
fun SprtNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = LandingRoute,
        modifier = modifier
    ) {
        authSection(
            onSignInClicked = navController::navigateToSignIn,
            onSignUpClicked = navController::navigateToSignUp
        )
    }

}