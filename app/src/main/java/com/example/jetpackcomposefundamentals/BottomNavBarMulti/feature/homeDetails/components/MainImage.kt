package com.example.jetpackcomposefundamentals.BottomNavBarMulti.feature.homeDetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ComposeUiProject.HomeApp.core.model.PropertyHome
import com.example.ComposeUiProject.HomeApp.feature.components.MetaChip
import com.example.ComposeUiProject.HomeApp.util.getDrawableId
import com.example.jetpackcomposefundamentals.R


@Composable
fun MainImage(
    title: String,
    description: String,
    picPath: String,
    navController: NavController,
) {

    ConstraintLayout(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 40.dp)
            .height(350.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
    ) {
        val (mainImage, title, description, backBtn, bookmarkBtn, bedItem, bathItem) = createRefs()

        Image(
            painter = painterResource(getDrawableId(picPath)),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .constrainAs(mainImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )

        Box(
            modifier = Modifier
                .background(shape = CircleShape, color = Color(0x7C494545))
                .clickable {
                    // Handle back navigation
                    navController.navigateUp()
                }
                .constrainAs(backBtn) {
                    top.linkTo(parent.top, 18.dp)
                    start.linkTo(parent.start, 18.dp)
                }) {
            Image(
                painter = painterResource(R.drawable.back_ios),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(3.dp)
            )
        }

        Box(
            modifier = Modifier
                .background(shape = CircleShape, color = Color(0x7C494545))
                .constrainAs(bookmarkBtn) {
                    top.linkTo(parent.top, 18.dp)
                    end.linkTo(parent.end, 18.dp)
                }) {
            Image(
                painter = painterResource(R.drawable.bookmark_outline),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp)
            )
        }

        Row(
            modifier = Modifier
                .constrainAs(bedItem) {
                    start.linkTo(parent.start, 24.dp)
                    bottom.linkTo(parent.bottom, 18.dp)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .background(color = Color(0x7C494545), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.bed),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color(0xFFD7D3D3)),
                    modifier = Modifier
                        .size(25.dp)
                        .padding(2.dp)
                )
            }

            Text(
                text = "6 Bedroom",
                textAlign = TextAlign.Center,
                color = Color(0xFFCECBCB),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(horizontal = 6.dp)
            )

        }

    }
}

@Preview
@Composable
fun PropertyCardPreview() {
    val navController = rememberNavController()
    MainImage("Modern Apartment", "123 Main St, Anytown, USA", "pic_4", navController)
}
