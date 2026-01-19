package com.sproutify.module.model

import androidx.compose.runtime.Composable

/**
 * widget - composable which accepts the space id as a parameter. This is key'd internally
 * for the viewmodel such that the correct data is loaded on the dashboard.
 */
abstract class Module(
    val moduleId: String,
    val route: Any,
    val widget: (@Composable (String) -> Unit)? = null,
)