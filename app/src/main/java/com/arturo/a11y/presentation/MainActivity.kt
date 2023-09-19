package com.arturo.a11y.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arturo.a11y.presentation.theme.A11yTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A11yTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "menu") {

                    composable("menu") {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Button(onClick = { navController.navigate("merged-nodes") }) {
                                Text(text = "to merged nodes")
                            }

                            Button(onClick = { navController.navigate("traversal-order") }) {
                                Text(text = "to traversal order")
                            }

                            Button(onClick = { navController.navigate("roles") }) {
                                Text(text = "to roles")
                            }
                        }
                    }

                    composable("merged-nodes") {
                        Column() {
                            NoMergeComponent()
                            Spacer(modifier = Modifier.height(8.dp))
                            MergeComponent()
                        }
                    }

                    composable("traversal-order") {
                        Column() {
                            NoTraversalGroupDemo()
                            Spacer(modifier = Modifier.height(8.dp))
                            TraversalGroupDemo()
                        }
                    }

                    composable("roles") {
                        Column() {
                            RolesAndStates()
                            Spacer(modifier = Modifier.height(8.dp))
                            RolesAndStates2()
                        }
                    }
                }
            }
        }
    }
}