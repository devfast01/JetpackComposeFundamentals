package com.example.ComposeUiProject.HomeApp.feature.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposefundamentals.R


@Composable
@Preview
fun SearchRow() {
    var q by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = q,
            onValueChange = { q = it },
            singleLine = true,
            placeholder = {
                Text(
                    "Street,Address,City ...",
                    color = colorResource(R.color.grey)
                )
            },
            leadingIcon = {
                Image(
                    painter = painterResource(R.drawable.search_icon),
                    modifier = Modifier.size(18.dp),
                    contentDescription = null
                )
            },
            modifier = Modifier
                .weight(1f)
                .height(52.dp)
                .clip(RoundedCornerShape(30.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorResource(R.color.white),
                unfocusedContainerColor = colorResource(R.color.white),
                disabledContainerColor = colorResource(R.color.white),
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = colorResource(R.color.black)
            )
        )

        Spacer(Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(colorResource(R.color.blue)), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.settings),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}