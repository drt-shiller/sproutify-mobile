package com.sproutify.auth.login

data class SignInUiState(
    val email: String = "",
    val password: String = "",
    val onEmailChanged: (String) -> Unit,
    val onPasswordChanged: (String) -> Unit,
    val onSignIn: (String, String) -> Unit,
    val reset: () -> Unit,
    val signInState: SignInState = SignInState.Ready
) {
    val isLoading: Boolean
        get() = signInState is SignInState.Loading

    val isSignInEnabled: Boolean
        get() = (email.isNotBlank() && password.isNotBlank()) && !isLoading
}

// Specifically for handling the network sign in state representation
sealed interface SignInState {

    data object Ready: SignInState

    data object Loading: SignInState
}
