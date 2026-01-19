package com.sproutify.space.dashboard

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = DashboardViewModel.Factory::class)
class DashboardViewModel @AssistedInject constructor(
    @Assisted val spaceId: String,
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(
            spaceId: String
        ): DashboardViewModel
    }
}