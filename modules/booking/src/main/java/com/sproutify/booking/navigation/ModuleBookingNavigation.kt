package com.sproutify.booking.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sproutify.booking.ui.BookingScreen
import kotlinx.serialization.Serializable

@Serializable
data object BookingModuleRoute

fun NavGraphBuilder.bookingModule() {
    composable<BookingModuleRoute> {
        BookingScreen()
    }
}