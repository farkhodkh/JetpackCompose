package com.example.jetpackcompose.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@ExperimentalComposeUiApi
@Composable
fun MainView(
    onClickListener: () -> Unit
) {
    val (refLogo, refTitle, refDescription) = createRefs()

    val logo = ConstrainedLayoutReference(refLogo)
    val title = ConstrainedLayoutReference(refTitle)
    val description = ConstrainedLayoutReference(refDescription)

    Box(
        modifier = Modifier
            .clickable { onClickListener() }
            .size(height = 350.dp, width = 250.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
        ) {
            Text(text = "TopStart")
            Text(text = "Center")
            Text(text = "BottomEnd")
        }

        Spacer(modifier = Modifier.size(3.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 90.dp)
                .fillMaxWidth()
        ) {
            Text(text = "TopStart")
            Text(text = "Center")
            Text(text = "BottomEnd")
        }
    }

    Spacer(modifier = Modifier.size(3.dp))

    ConstraintLayout(
        modifier = Modifier
            .padding(top = 110.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "ConstraintLayout Start",
            modifier = Modifier
                .constrainAs(
                    ref = logo
                ) {
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = "ConstraintLayout Center",
            modifier = Modifier.constrainAs(title) {
                top.linkTo(logo.bottom)
                linkTo(
                    start = logo.end,
                    end = parent.end,
                    startMargin = 8.dp,
                    endMargin = 8.dp
                )
                width = Dimension.fillToConstraints
            }
        )
        Text(
            text = "ConstraintLayout End",
            modifier = Modifier
                .constrainAs(description) {
                    top.linkTo(title.bottom, 8.dp)
                    end.linkTo(parent.end, 8.dp)
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
@Suppress("UnusedPrivateMember")
private fun MainViewPreview() {
    MainView({})
}