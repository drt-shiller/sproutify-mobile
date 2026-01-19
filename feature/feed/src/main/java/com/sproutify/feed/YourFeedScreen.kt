package com.sproutify.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sproutify.designsystem.theme.SprtTheme
import com.sproutify.model.Space
import com.sproutify.ui.SprtSquareButton

@Composable
fun YourFeedScreen(
    modifier: Modifier = Modifier,
    viewModel: YourFeedViewModel = hiltViewModel(),
    onSpaceClick: (String, String) -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    when (state) {
        YourFeedUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is YourFeedUiState.Ready -> {
            YourFeedReady(
                state = state as YourFeedUiState.Ready,
                modifier = modifier,
                onSpaceClick = onSpaceClick
            )
        }
    }
}

@Composable
private fun YourFeedReady(
    modifier: Modifier = Modifier,
    state: YourFeedUiState.Ready,
    onSpaceClick: (String, String) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        TopBar()

        Spaces(
            spaces = state.spaces,
            onSpaceClick = onSpaceClick
        )
    }
}

@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(
            start = SprtTheme.padding.m,
            end = SprtTheme.padding.m,
            top = SprtTheme.padding.s
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
                .background(SprtTheme.colors.outline)
        )

        Spacer(Modifier.width(SprtTheme.spacing.m))

        Column {
            Text("Welcome,", style = SprtTheme.typography.titleSmall)
            Spacer(Modifier.height(4.dp))
            Text("David", style = SprtTheme.typography.titleMedium)
        }
    }
}

@Composable
private fun Spaces(
    modifier: Modifier = Modifier,
    spaces: List<Space>,
    onSpaceClick: (String, String) -> Unit
) {
    Column(modifier = modifier.padding(top = SprtTheme.padding.s)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = SprtTheme.padding.m),
                text = "Spaces",
                style = SprtTheme.typography.titleLarge
            )

            TextButton(onClick = {}) {
                Text("See All")
            }
        }


        Spacer(Modifier.height(SprtTheme.spacing.s))

        LazyRow(
            modifier
                .fillMaxWidth()
                .padding(bottom = SprtTheme.padding.m),
            horizontalArrangement = Arrangement.spacedBy(SprtTheme.spacing.s)
        ) {

            item {
                Spacer(modifier = Modifier.width(SprtTheme.spacing.s))
            }


            item {
                SprtSquareButton(
                    borderWidth = 2.dp,
                    containerColor = Color.Unspecified,
                    onClick = {}
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = null,
                            tint = SprtTheme.colors.outline
                        )
                        Text(
                            text = "Add\nSpace",
                            style = SprtTheme.typography.titleSmall,
                            color = SprtTheme.colors.outline,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            items(spaces.size) { i ->
                SprtSquareButton(onClick = { onSpaceClick(spaces[i].spaceId, spaces[i].spaceName) }) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = spaces[i].spaceName,
                            maxLines = 2,
                            style = SprtTheme.typography.titleSmall,
                            color = SprtTheme.colors.onSurface,
                            textAlign = TextAlign.Center
                        )
                    }
                }

            }

            item {
                Spacer(modifier = Modifier.width(SprtTheme.spacing.s))
            }
        }
        HorizontalDivider(modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
private fun YourFeedScreenPreview() {
    SprtTheme {
        YourFeedReady(
            onSpaceClick = {_, _ -> },
            state = YourFeedUiState.Ready(
                spaces = listOf(
                    Space(
                        spaceId = "123232-123-123",
                        spaceName = "2 Aleea Lunca Bradului",
                        imgUrl = "",
                        modules = emptyList()
                    ),
                    Space(
                        spaceId = "123232-123-123",
                        spaceName = "7 Unger Cresant",
                        imgUrl = "",
                        modules = emptyList()
                    )
                )
            ),
        )
    }
}