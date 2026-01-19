package com.sproutify.space

import androidx.lifecycle.ViewModel
import com.sproutify.sproutify.ModuleRegistry

import com.sproutify.module.model.ModuleRoute
import com.sproutify.space.navigation.DashboardRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SpaceViewModel @Inject constructor(private val modules: com.sproutify.sproutify.ModuleRegistry) : ViewModel() {

    private var _uiState = MutableStateFlow<List<Any>>(emptyList())
    val uiState = _uiState.asStateFlow()

    init {
       // TODO: Lookup the SpaceId and Module Ids
       val routes = mutableListOf<Any>()
        routes.add(ModuleRoute("Dashboard", DashboardRoute))
        modules.get("123242323")?.let { module -> routes.add(ModuleRoute("Booking", module.route ) ) }
        modules.get("1000000")?.let { module -> routes.add(ModuleRoute("Maintenance", module.route)) }
        _uiState.update { routes }
    }
}

