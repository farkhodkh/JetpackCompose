package com.example.jetpackcompose.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun MainView(
    onClickListener: () -> Unit
) {
    Text(
        text = "Main view",
        style = MaterialTheme.typography.body2,
        color = MaterialTheme.colors.onSurface,
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        modifier = Modifier
            .padding()
            .clickable {
                onClickListener()
            }
    )
}