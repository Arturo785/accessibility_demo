package com.arturo.a11y.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RolesAndStates(modifier: Modifier = Modifier) {
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
                Text(
                    text = "Profile text",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.semantics { heading() })
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut" +
                            " aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in" +
                            " voluptate velit esse cillum dolore"
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RolesAndStates2(modifier: Modifier = Modifier) {
    var isChecked by remember {
        mutableStateOf(false)
    }

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
                Text(
                    text = "Profile text",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.semantics { heading() })
                Text(
                    modifier = Modifier.semantics { invisibleToUser() },
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut" +
                            " aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in" +
                            " voluptate velit esse cillum dolore"
                )

                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .offset(x = (-40).dp)
                        .toggleable(
                            value = isChecked,
                            role = Role.Checkbox,
                            onValueChange = { isChecked = !isChecked })
                        .clearAndSetSemantics { contentDescription = "Option checkbox" }
                ) {
                    Text("Option", modifier = Modifier.padding(top = 12.dp))
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = !isChecked },
                        colors = CheckboxDefaults.colors(uncheckedColor = Color.DarkGray)
                    )
                }
            }
        }
    }
}