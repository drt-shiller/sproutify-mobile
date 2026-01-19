package com.sproutify.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sproutify.model.Space
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YourFeedViewModel @Inject constructor() : ViewModel() {

    private var _uiState = MutableStateFlow<YourFeedUiState>(YourFeedUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(500L)
            _uiState.emit(YourFeedUiState.Ready(spaces = listOf(
                Space(
                    spaceId = "1000001",
                    spaceName = "2 Aleea Lunca Bradului",
                    imgUrl = "",
                ),
                Space(
                    spaceId = "1000002",
                    spaceName = "7 Unger Cresant",
                    imgUrl = "",
                )
            )))
        }
    }

}