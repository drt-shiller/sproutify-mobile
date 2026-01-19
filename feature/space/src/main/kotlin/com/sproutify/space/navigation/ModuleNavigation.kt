package com.sproutify.space.navigation

import androidx.navigation.NavGraphBuilder
import com.sproutify.booking.navigation.bookingModule
import com.sproutify.maintenance.navigation.maintenanceModule

fun NavGraphBuilder.moduleNavGraph() {
    bookingModule()
    maintenanceModule()
}