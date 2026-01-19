package com.sproutify.feed

import com.sproutify.model.Space

sealed interface YourFeedUiState {

    data object Loading: YourFeedUiState

    data class Ready(
        val spaces: List<Space> = emptyList(),
        val messages: List<Any> = emptyList()
    ): YourFeedUiState
}