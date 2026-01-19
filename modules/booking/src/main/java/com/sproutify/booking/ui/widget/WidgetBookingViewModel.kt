package com.sproutify.booking.ui.widget

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class WidgetBookingViewModel @AssistedInject constructor(
    @Assisted private val spaceId: String,
) : ViewModel() {

}

// 2. Define the @AssistedFactory interface
@AssistedFactory
interface WidgetBookingViewModelFactory {
    fun create(spaceId: String): WidgetBookingViewModel
}