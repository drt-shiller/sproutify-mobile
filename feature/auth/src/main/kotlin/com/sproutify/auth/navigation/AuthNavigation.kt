package com.sproutify.auth.navigation

import android.util.Log
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sproutify.auth.landing.LandingScreen
import com.sproutify.auth.login.SignInScreen
import com.sproutify.auth.onboarding.SignUpScreen
import kotlinx.serialization.Serializable


@Serializable data object AuthBaseRoute

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
    modifier: Modifier = Modifier,
    onSignInClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    navigateToFeed: () -> Unit
) {
    navigation<AuthBaseRoute>(startDestination = LandingRoute) {
        composable<LandingRoute>() {
            LandingScreen(
                modifier = modifier,
                onSignInClicked = onSignInClicked,
                onSignUpClicked = onSignUpClicked
            )
        }

        composable<SignInRoute> {
            SignInScreen(
                modifier = modifier,
                navigateToSignUp = onSignUpClicked,
                navigateToForgotPassword = {},
                navigateToFeed = navigateToFeed
            )
        }

        composable<SignUpRoute> {
            SignUpScreen(
                modifier = modifier
            )
        }
    }
}