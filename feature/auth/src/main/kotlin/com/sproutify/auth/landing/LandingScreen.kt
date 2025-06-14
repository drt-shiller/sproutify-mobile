package com.sproutify.auth.landing

import android.graphics.Paint.Align
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sproutify.designsystem.theme.SprtTheme
import com.sproutify.designsystem.R as DesignR
import com.sproutify.localization.R as LocalR
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

// TODO: Handle Analytics
// TODO: Handle Localization
// TODO: Convert to use SprtButton
// TODO: Navigation
@Composable
fun LandingScreen(
    modifier: Modifier = Modifier,
    onSignInClicked: () -> Unit,
    onSignUpClicked: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize().padding(start = SprtTheme.padding.m, end = SprtTheme.padding.m, bottom = SprtTheme.padding.m)) {
        Text(modifier = Modifier.align(Alignment.TopStart), text = stringResource(LocalR.string.app_name), style = SprtTheme.typography.headlineSmall)

        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(DesignR.drawable.img_growcommunity_headline),
            contentDescription = "text_headline"
        )

        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Button(
                modifier = Modifier.size(height = 56.dp, width = 225.dp),
                onClick = onSignInClicked,
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = SprtTheme.colors.primaryContainer,
                    contentColor = SprtTheme.colors.onPrimaryContainer
                )
            ) {
                Text(
                    text = stringResource(LocalR.string.app_common_signIn_camelCase),
                    style = SprtTheme.typography.titleMedium)
            }

            Spacer(modifier = Modifier.height(SprtTheme.padding.m))

            val text = buildAnnotatedString {
                append(stringResource(LocalR.string.landing_register_now))
                withStyle(  SprtTheme.typography.titleMedium.toSpanStyle().copy(color = SprtTheme.colors.secondary, )) {
                    append(" ${stringResource(LocalR.string.app_common_signUp_camelCase)}")
                }
            }

            Text(
                modifier = Modifier.clickable(onClick = onSignUpClicked),
                style = SprtTheme.typography.titleMedium,
                text = text
            )
        }
    }
}

@Preview
@Composable
private fun LandingScreenPreview() {
    SprtTheme {
        LandingScreen(
            onSignInClicked = {},
            onSignUpClicked = {}
        )
    }
}