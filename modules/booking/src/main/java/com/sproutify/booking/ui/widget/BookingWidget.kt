package com.sproutify.booking.ui.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sproutify.designsystem.theme.SprtTheme

@Composable
fun BookingWidget(
    modifier: Modifier = Modifier,
    viewModel: WidgetBookingViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxWidth().height(200.dp).border(1.dp, SprtTheme.colors.primary, RoundedCornerShape(16.dp)))
}

@Preview
@Composable
private fun BookingWidgetPreview() {
    SprtTheme {
        BookingWidget()
    }
}