package com.sproutify.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO: Add IoDisptacher
@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {

    private var _uiState = MutableStateFlow<SignInUiState>(_emptyState)
    val uiState = _uiState.asStateFlow()

    private var _uiEvent = MutableSharedFlow<SignInUiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    private fun handleAction(
        action: SignInUiAction
    ) {
        when(action){
            is SignInUiAction.OnEmailChange -> { _uiState.update { state -> state.copy(email = action.email) }}
            is SignInUiAction.OnPasswordChange ->  { _uiState.update { state -> state.copy(password = action.password) }}
            is SignInUiAction.OnSignInClicked -> {
                viewModelScope.launch {
                    _uiState.update { state -> state.copy(signInState = SignInState.Loading) }
                    delay(500L)
                    _uiState.update { state -> state.copy(signInState = SignInState.Ready) }
                    _uiEvent.emit(SignInUiEvent.NavigateToFeed)
                }
            }
            SignInUiAction.ResetState -> {
                _uiState.update { _emptyState }
            }
        }
    }

    private val _emptyState: SignInUiState
        get() = SignInUiState(
            onEmailChanged = { email ->  handleAction(SignInUiAction.OnEmailChange(email)) },
            onPasswordChanged = { password -> handleAction(SignInUiAction.OnPasswordChange(password)) },
            onSignIn = { email, password ->  handleAction(SignInUiAction.OnSignInClicked(email, password)) },
            reset = { handleAction(SignInUiAction.ResetState) }
        )
}