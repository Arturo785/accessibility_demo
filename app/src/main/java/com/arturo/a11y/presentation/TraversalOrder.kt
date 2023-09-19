package com.arturo.a11y.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp


@Composable
fun NoTraversalGroupDemo() {
    Row(modifier = Modifier.background(Color.Cyan)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.background(Color.LightGray)
        ) {
            Text(text = "First")
            Text(text = "Second")
        }
        Text(text = "Third")
    }
}


@Composable
fun TraversalGroupDemo() {
    Row(modifier = Modifier.background(Color.Cyan)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .background(Color.LightGray)
                .semantics { isTraversalGroup = true }
        ) {
            Text(text = "First")
            Text(text = "Second")
        }
        Text(text = "Third")
    }
}