package com.sproutify.auth.login

sealed interface SignInUiEvent {
    data object NavigateToFeed : SignInUiEvent

    // TODO: Modify to handle specific error types such that we can localize error messages
    data class ShowError(val message: String) : SignInUiEvent
}