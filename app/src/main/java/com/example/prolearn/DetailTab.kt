package com.example.prolearn


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DetailTabScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("About", "Lessons","Reviews")

    Column {

        Box (
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 10.dp)
        ){
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box(
                        modifier = Modifier
                            .width(80.dp)
                            .height(30.dp)
                            .border(
                                width = 0.dp,
                                color = colorResource(id = R.color.light_blue),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .clip(RoundedCornerShape(16.dp))
                            .background(colorResource(id = R.color.light_blue))
                    ) {

                        Text(
                            text = "Design",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(start = 6.dp, end = 6.dp),
                            color = colorResource(id = R.color.blue),
                            fontSize = 14.sp
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Favorite Icon",
                            tint = colorResource(id = R.color.yellow),
                            modifier = Modifier
                                .size(18.dp)
                                .padding(0.dp)
                        )
                        Text(
                            text = "4.5",
                            modifier = Modifier
                                .padding(start = 2.dp),
                            color = colorResource(id = R.color.black),
                            fontSize = 16.sp
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp),
                    text = "Business",
                    fontSize = 23.sp,
                    color = colorResource(id = R.color.grey),
                    fontWeight = FontWeight.Medium
                )
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    Row(
                        modifier = Modifier
                            .padding(top = 7.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Profile Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "John Mason",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Text(
                        modifier = Modifier
                            .padding(top = 7.dp),
                        text = "Lessons(25)",
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.grey_text),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(4.dp),
                    color = colorResource(id = R.color.blue)
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },

                    text = {
                        Text(title,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            color = if (selectedTabIndex == index) {
                                colorResource(id = R.color.blue)
                            } else {
                                colorResource(id = R.color.grey_text)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.Medium
                        )
                    }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> About()
            1 -> Lessons()
            2 -> Reviews()

        }
    }
}

