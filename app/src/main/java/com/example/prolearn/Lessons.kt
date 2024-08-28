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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Lessons() {

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 10.dp, top = 10.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(top = 10.dp),
            text = "Lessons (5)",
            fontSize = 20.sp,
            color = colorResource(id = R.color.grey),
            fontWeight = FontWeight.Medium
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                modifier = Modifier
                    .padding(start = 0.dp, top = 4.dp),
                text = "Part 1 Introduction",
                fontSize = 18.sp,
                color = colorResource(id = R.color.grey_text),
                fontWeight = FontWeight.Medium
            )

            Text(
                modifier = Modifier
                    .padding(top = 4.dp),
                text = "25min",
                fontSize = 18.sp,
                color = colorResource(id = R.color.blue),
                fontWeight = FontWeight.Medium
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()

                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.light_grey),
                    shape = RoundedCornerShape(30.dp)
                )
                .clip(RoundedCornerShape(30.dp))
                .background(colorResource(id = R.color.white))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 10.dp)
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.light_grey),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .clip(RoundedCornerShape(30.dp))
                    .background(colorResource(id = R.color.white))
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(

                    ) {
                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .height(40.dp)
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(100.dp)
                                )
                                .clip(RoundedCornerShape(100.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {

                            Text(
                                text = "01",
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(start = 6.dp, end = 6.dp),
                                color = colorResource(id = R.color.blue),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Box(
                            modifier = Modifier

                                .padding(start = 8.dp)

                        ) {

                            Column {
                                Text(
                                    text = "Road map",
                                    modifier = Modifier
                                        .padding(start = 14.dp, end = 6.dp),
                                    color = colorResource(id = R.color.grey),
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = "02:00",
                                    modifier = Modifier
                                        .padding(start = 14.dp, end = 6.dp),
                                    color = colorResource(id = R.color.grey_text),
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .border(
                                width = 0.dp,
                                color = colorResource(id = R.color.light_grey),
                                shape = RoundedCornerShape(100.dp)
                            )
                            .clip(RoundedCornerShape(100.dp))
                            .background(colorResource(id = R.color.light_blue))
                    ) {


                        Icon(
                            painter = painterResource(id = R.drawable.play_icon),
                            contentDescription = "",
                            tint = colorResource(id = R.color.blue),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(18.dp)

                        )
                    }
                }
            }

            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 10.dp)
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.light_grey),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .clip(RoundedCornerShape(30.dp))
                    .background(colorResource(id = R.color.white))
            ){
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(

                    ) {
                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .height(40.dp)
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(100.dp)
                                )
                                .clip(RoundedCornerShape(100.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {

                            Text(
                                text = "01",
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(start = 6.dp, end = 6.dp),
                                color = colorResource(id = R.color.blue),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Box(
                            modifier = Modifier

                                .padding(start = 8.dp)

                        ) {

                            Column {
                                Text(
                                    text = "Road map",
                                    modifier = Modifier
                                        .padding(start = 14.dp, end = 6.dp),
                                    color = colorResource(id = R.color.grey),
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = "02:00",
                                    modifier = Modifier
                                        .padding(start = 14.dp, end = 6.dp),
                                    color = colorResource(id = R.color.grey_text),
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .border(
                                width = 0.dp,
                                color = colorResource(id = R.color.light_grey),
                                shape = RoundedCornerShape(100.dp)
                            )
                            .clip(RoundedCornerShape(100.dp))
                            .background(colorResource(id = R.color.light_blue))
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.lock_icon),
                            contentDescription = "Favorite Icon",
                            tint = colorResource(id = R.color.blue),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(18.dp)

                        )
                    }
                }
            }
        }


    }

}