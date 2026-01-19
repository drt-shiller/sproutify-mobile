package com.sproutify.sproutify.di

import com.sproutify.booking.BookingModule
import com.sproutify.maintenance.MaintenanceModule
import com.sproutify.module.ModuleRegistry
import dagger.Module

import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ModuleRegistry {

    @Provides
    fun provideModuleRegistry(): ModuleRegistry {
        return ModuleRegistry.Builder()
            .add(BookingModule)
            .add(MaintenanceModule)
            .build()
    }
}
