package com.example.ComposeUiProject.HomeApp.feature.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ComposeUiProject.HomeApp.feature.components.HomeTopBar
import com.example.jetpackcomposefundamentals.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ComposeUiProject.HomeApp.feature.components.OptionRow


@Composable
fun HomeProfileScreen(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.lightGreyHome)),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item { Spacer(Modifier.height(10.dp)) }
        item { HomeTopBar(onBackClick = { navController.navigateUp() }) }
        item { Spacer(Modifier.height(16.dp)) }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.profile), contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .size(100.dp)
                        .height(220.dp)
                        .clip(RoundedCornerShape(30.dp))
                )
            }
        }
        item { Spacer(Modifier.height(16.dp)) }
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Begli Welli",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.black)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "+9936285**29",
                    fontSize = 16.sp,
                    color = colorResource(R.color.black)
                )
                Text(
                    "iot123tech@gmail.com",
                    fontSize = 16.sp,
                    color = colorResource(R.color.black)
                )
            }
        }
        item { Spacer(Modifier.height(24.dp)) }

        item { OptionRow("Account Information") }
        item { OptionRow("Security") }
        item { OptionRow("Notification") }
        item { OptionRow("Language") }
        item { OptionRow("Team & Condition") }
        item { OptionRow("Privacy Policy") }
        item { Spacer(Modifier.height(8.dp)) }
    }

}

@Preview
@Composable
fun HomeProfileScreenPreview() {
    val navController = rememberNavController()
    HomeProfileScreen(navController)
}
