package com.sproutify.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Padding(
    val xs: Dp = Dp.Unspecified, // Extra Small
    val s: Dp = Dp.Unspecified, // Small
    val m: Dp = Dp.Unspecified, // Medium
    val l: Dp = Dp.Unspecified, // Large
    val xl: Dp = Dp.Unspecified, // Extra Large
    val xxl: Dp = Dp.Unspecified, // Extra Extra Large
    val ms: Dp = Dp.Unspecified // Massive
)

val SprtPadding = Padding(
    xs = 4.dp,
    s = 8.dp,
    m = 16.dp,
    l = 24.dp,
    xl = 32.dp,
    xxl = 56.dp,
    ms = 64.dp
)