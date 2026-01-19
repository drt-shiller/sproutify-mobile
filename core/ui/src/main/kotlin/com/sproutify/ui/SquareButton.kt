package com.sproutify.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sproutify.designsystem.theme.SprtTheme

@Composable
fun SprtSquareButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 84.dp,
    borderColor: Color = SprtTheme.colors.outline,
    containerColor: Color = SprtTheme.colors.primary,
    borderWidth: Dp = Dp.Unspecified,
    contentPadding: PaddingValues = PaddingValues(SprtTheme.padding.s),
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.size(size)
        .clip(RoundedCornerShape(16.dp))
        .clickable(onClick = onClick)
        .border(borderWidth, shape = RoundedCornerShape(16.dp), color = borderColor)
        .background(containerColor)
        .padding(contentPadding),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Preview
@Composable
private fun SprtSquareButtonPreview() {
    SprtTheme {
        SprtSquareButton(
            onClick = {}
        ) {

        }
    }
}