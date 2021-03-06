package com.example.jetpackcompose.ui.login

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.material3.FabPosition
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import kotlinx.coroutines.launch
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun LoginScreen() {

    val bottomMenuItems = listOf(
        NavigationItem(title = "Item 1", iconRes = R.drawable.ic_one),
        NavigationItem(title = "Item 2", iconRes = R.drawable.ic_two),
        NavigationItem(title = "Item 3", iconRes = R.drawable.ic_three)
    )

    val drawerMenuItems = listOf(
        NavigationItem(title = "Section 1", iconRes = R.drawable.ic_one),
        NavigationItem(title = "Section 2", iconRes = R.drawable.ic_two),
        NavigationItem(title = "Section 3", iconRes = R.drawable.ic_three)
    )

    val selectedItem = remember { mutableStateOf(bottomMenuItems.first().title) }

    /**
     * By default, drawer state is closed, but we can customize it.
     *
     * Closed drawer state: `rememberScaffoldState(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)`
     * Opened drawer state: `rememberScaffoldState(drawerState = rememberDrawerState(initialValue = DrawerValue.Open))`
     */
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn {
                items(drawerMenuItems, key = null) {
                    ListItem(
                        text = { Text(text = "Category ${it.title}") },
                        icon = {
                            Icon(
                                painter = painterResource(id = it.iconRes),
                                contentDescription = it.title
                            )
                        }
                    )
                }
            }
        },
        topBar = {
            TopAppBar(
                title = { Text(text = "Title") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch { scaffoldState.drawerState.open() }
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu),
                            contentDescription = "Menu"
                        )
                    }
                }
            )
        },
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = selectedItem.value,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            }
        },
        bottomBar = {
            BottomNavigation {
                bottomMenuItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = screen.title == selectedItem.value,
                        onClick = { selectedItem.value = screen.title },
                        label = { Text(screen.title) },
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.iconRes),
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        //scaffoldState.drawerState.showSnackbar("Button clicked")
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }
    )
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
@Suppress("UnusedPrivateMember")
private fun LoginScreenPreview() {
    LoginScreen()
}

data class NavigationItem(
    val title: String,
    @DrawableRes val iconRes: Int
)