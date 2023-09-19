package com.arturo.a11y.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NoMergeComponent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
        ) {
            Image(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "image description",
                modifier = Modifier
                    .padding(top = 4.dp)
                    .size(64.dp)

            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "Profile text", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text(text = "Extra text description")
            }
        }

        TextButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterEnd),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Icon(
                imageVector = Icons.Filled.DateRange,
                modifier = Modifier.size(30.dp),
                contentDescription = "drawable icons",
            )
        }
    }
}

@Composable
fun MergeComponent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .semantics(mergeDescendants = true) {
                    contentDescription = "We can make text richer"
                }
            //.clearAndSetSemantics() { contentDescription = "Our own custom text" }
        ) {
            Image(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "image description",
                modifier = Modifier
                    .padding(top = 4.dp)
                    .size(64.dp)

            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "Profile text", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text(text = "Extra text description")
            }
        }

        TextButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterEnd),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Icon(
                imageVector = Icons.Filled.DateRange,
                modifier = Modifier.size(30.dp),
                contentDescription = "drawable icons",
            )
        }
    }
}


//  .semantics(mergeDescendants = true) {
//
//  }

//  .clearAndSetSemantics() { contentDescription = "Our own custom text" }