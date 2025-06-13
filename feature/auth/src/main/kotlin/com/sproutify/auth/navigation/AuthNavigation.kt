package com.sproutify.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sproutify.auth.landing.LandingScreen
import com.sproutify.auth.login.SignInScreen
import com.sproutify.auth.onboarding.SignUpScreen
import kotlinx.serialization.Serializable

@Serializable data object LandingRoute

@Serializable data object SignInRoute

@Serializable data object SignUpRoute

fun NavController.navigateToSignIn( navOptions: NavOptionsBuilder.() -> Unit = {} ) {
    navigate(route = SignInRoute) {
        navOptions()
    }
}

fun NavController.navigateToSignUp( navOptions: NavOptionsBuilder.() -> Unit = {} ) {
    navigate(route = SignUpRoute) {
        navOptions()
    }
}

fun NavGraphBuilder.authSection(
    onSignInClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
) {
    navigation<LandingRoute>(startDestination = LandingRoute) {
        composable<LandingRoute>() {
            LandingScreen(
                onSignInClicked = onSignInClicked,
                onSignUpClicked = onSignUpClicked
            )
        }

        composable<SignInRoute> {
            SignInScreen()
        }

        composable<SignUpRoute> {
            SignUpScreen()
        }
    }
}