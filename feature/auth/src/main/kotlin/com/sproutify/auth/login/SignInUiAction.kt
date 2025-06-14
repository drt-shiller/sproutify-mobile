package com.sproutify.auth.login

sealed interface SignInUiAction {

    data class OnPasswordChange(val password: String): SignInUiAction

    data class OnEmailChange(val email: String): SignInUiAction

    data class OnSignInClicked(val email: String, val password: String): SignInUiAction

    data object ResetState: SignInUiAction
}