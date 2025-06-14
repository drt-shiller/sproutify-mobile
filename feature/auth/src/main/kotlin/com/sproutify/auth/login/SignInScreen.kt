package com.sproutify.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sproutify.designsystem.theme.SprtTheme
import kotlinx.coroutines.flow.collectLatest
import com.sproutify.localization.R as LocalR

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel(),
    navigateToSignUp: () -> Unit,
    navigateToForgotPassword: () -> Unit,
    navigateToFeed: () -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.uiEvent.collectLatest { event ->
            when (event) {
                SignInUiEvent.NavigateToFeed -> {

                }

                is SignInUiEvent.ShowError -> {

                }
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = SprtTheme.padding.m,
                end = SprtTheme.padding.m,
                bottom = SprtTheme.padding.m
            )
    ) {

        Column {
            Text(
                text = stringResource(LocalR.string.app_common_signIn_camelCase),
                style = SprtTheme.typography.headlineLarge
            )

            Spacer(Modifier.height(SprtTheme.spacing.ms))

            SignInForm(
                email = state.email,
                password = state.password,
                onEmailChanged = state.onEmailChanged,
                onPasswordChange = state.onPasswordChanged
            )

            TextButton(
                modifier = Modifier.align(Alignment.End),
                onClick = {}) {
                Text("Forgot Password?")
            }
        }

        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Button(
                modifier = Modifier.size(height = 56.dp, width = 225.dp),
                onClick = {
                    state.onSignIn(state.email, state.password)
                },
                enabled = state.isSignInEnabled,
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = SprtTheme.colors.primaryContainer,
                    contentColor = SprtTheme.colors.onPrimaryContainer
                )
            ) {
                if (state.isLoading) {
                    CircularProgressIndicator()
                } else {
                    Text(
                        text = stringResource(LocalR.string.app_common_signIn_camelCase),
                        style = SprtTheme.typography.titleMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(SprtTheme.padding.m))

            val text = buildAnnotatedString {
                append(stringResource(LocalR.string.landing_register_now))
                withStyle(
                    SprtTheme.typography.titleMedium.toSpanStyle()
                        .copy(color = SprtTheme.colors.secondary)
                ) {
                    append(" ${stringResource(LocalR.string.app_common_signUp_camelCase)}")
                }
            }

            Text(
                modifier = Modifier
                    .clickable(onClick = navigateToSignUp),
                style = SprtTheme.typography.titleMedium,
                text = text
            )
        }
    }
}

@Composable
private fun SignInForm(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {

    Column {

        Text("Email", style = SprtTheme.typography.titleMedium)

        Spacer(Modifier.height(SprtTheme.spacing.s))

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            modifier = modifier.fillMaxWidth(),
            value = email,
            onValueChange = { value -> onEmailChanged(value) },
            placeholder = {
                Text(
                    stringResource(LocalR.string.signin_email_placeholder),
                    color = SprtTheme.colors.onSurface
                )
            },
        )

        Spacer(modifier = Modifier.height(SprtTheme.spacing.m))

        Text("Password", style = SprtTheme.typography.titleMedium)

        Spacer(Modifier.height(SprtTheme.spacing.s))

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            modifier = modifier.fillMaxWidth(),
            value = password,
            onValueChange = { value -> onPasswordChange(value) },
            placeholder = {
                Text(
                    stringResource(LocalR.string.signin_password_placeholder),
                    color = SprtTheme.colors.onSurface
                )
            },
        )
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    SprtTheme {
        SignInScreen(
            navigateToSignUp = {},
            navigateToFeed = {},
            navigateToForgotPassword = {}
        )
    }
}