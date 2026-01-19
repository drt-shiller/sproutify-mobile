package com.sproutify.maintenance.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sproutify.maintenance.MaintenanceScreen
import kotlinx.serialization.Serializable

@Serializable
data object MaintenanceModuleRoute

fun NavGraphBuilder.maintenanceModule() {
    composable<MaintenanceModuleRoute> {
        MaintenanceScreen()
    }
}