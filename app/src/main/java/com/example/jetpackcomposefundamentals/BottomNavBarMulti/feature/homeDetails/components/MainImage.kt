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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.ComposeUiProject.HomeApp.core.model.PropertyHome
import com.example.ComposeUiProject.HomeApp.feature.components.MetaChip
import com.example.ComposeUiProject.HomeApp.util.getDrawableId
import com.example.jetpackcomposefundamentals.R


@Composable
fun MainImage(
    title: String,
    description: String,
    picPath: String,
) {

    val white = colorResource(R.color.white)
    val blue = colorResource(R.color.blue)
    val black = colorResource(R.color.black)
    val grey = colorResource(R.color.grey)

    ConstraintLayout(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 40.dp)
            .height(350.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
    ) {
        val (mainImage, title, description, backBtn, bookmarkBtn, metaChip, bedItem, bathItem) = createRefs()

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
                .background(shape = CircleShape, color = Color(0x564F4C4C))
                .constrainAs(backBtn) {
                    top.linkTo(parent.top, 18.dp)
                    start.linkTo(parent.start, 18.dp)
                }) {
            Image(
                painter = painterResource(R.drawable.back_ios),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(3.dp)
            )
        }

    }
}

@Preview
@Composable
fun PropertyCardPreview() {
    MainImage("Modern Apartment", "123 Main St, Anytown, USA", "pic_1")
}
