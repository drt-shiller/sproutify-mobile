package com.sproutify.booking

import androidx.navigation.compose.composable
import com.sproutify.booking.navigation.BookingModuleRoute
import com.sproutify.booking.ui.BookingScreen
import com.sproutify.booking.ui.widget.BookingWidget
import com.sproutify.module.model.Module

object BookingModule : Module(
    moduleId = "123242323",
    route = BookingModuleRoute,
    widget = {
        BookingWidget()
    },
)
