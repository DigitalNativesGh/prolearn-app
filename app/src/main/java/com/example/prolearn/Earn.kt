package com.example.prolearn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle

@Composable
fun Earn() {

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 10.dp, top = 10.dp)
    ) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(top = 10.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.width(120.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.student_one_cover), // Replace with your image resource
                        contentDescription = "Course image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(6.dp))
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "10% off your next course",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 7.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "Daily login bonus $50 max discount",
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(30.dp)
                                .padding(2.dp)
                                .dashedBorder(
                                    color = colorResource(id = R.color.blue),
                                    strokeWidth = 2.dp,
                                    dashLength = 8.dp,
                                    gapLength = 4.dp,
                                    cornerRadius = 3.dp
                                )

                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "AJI76GH",
                                modifier = Modifier.align(Alignment.Center),
                                color = colorResource(id = R.color.blue),
                                fontSize = 14.sp
                            )
                        }

                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "Expire 20 Sept",
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.Medium
                        )

                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(top = 10.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.width(120.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.student_one_cover), // Replace with your image resource
                        contentDescription = "Course image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(6.dp))
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "10% off your next course",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 7.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "Daily login bonus $50 max discount",
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(30.dp)
                                .padding(2.dp)
                                .dashedBorder(
                                    color = colorResource(id = R.color.blue),
                                    strokeWidth = 2.dp,
                                    dashLength = 8.dp,
                                    gapLength = 4.dp,
                                    cornerRadius = 3.dp
                                )

                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "AJI76GH",
                                modifier = Modifier.align(Alignment.Center),
                                color = colorResource(id = R.color.blue),
                                fontSize = 14.sp
                            )
                        }

                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "Expire 20 Sept",
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.Medium
                        )

                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(top = 10.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.width(120.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.student_one_cover), // Replace with your image resource
                        contentDescription = "Course image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(6.dp))
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "10% off your next course",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 7.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "Daily login bonus $50 max discount",
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(30.dp)
                                .padding(2.dp)
                                .dashedBorder(
                                    color = colorResource(id = R.color.blue),
                                    strokeWidth = 2.dp,
                                    dashLength = 8.dp,
                                    gapLength = 4.dp,
                                    cornerRadius = 3.dp
                                )

                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "AJI76GH",
                                modifier = Modifier.align(Alignment.Center),
                                color = colorResource(id = R.color.blue),
                                fontSize = 14.sp
                            )
                        }

                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "Expire 20 Sept",
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.Medium
                        )

                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(top = 10.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.width(120.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.student_one_cover), // Replace with your image resource
                        contentDescription = "Course image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(6.dp))
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "10% off your next course",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 7.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "Daily login bonus $50 max discount",
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(30.dp)
                                .padding(2.dp)
                                .dashedBorder(
                                    color = colorResource(id = R.color.blue),
                                    strokeWidth = 2.dp,
                                    dashLength = 8.dp,
                                    gapLength = 4.dp,
                                    cornerRadius = 3.dp
                                )

                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "AJI76GH",
                                modifier = Modifier.align(Alignment.Center),
                                color = colorResource(id = R.color.blue),
                                fontSize = 14.sp
                            )
                        }

                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "Expire 20 Sept",
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.Medium
                        )

                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(top = 10.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.width(120.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.student_one_cover), // Replace with your image resource
                        contentDescription = "Course image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(6.dp))
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "10% off your next course",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 7.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "Daily login bonus $50 max discount",
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(30.dp)
                                .padding(2.dp)
                                .dashedBorder(
                                    color = colorResource(id = R.color.blue),
                                    strokeWidth = 2.dp,
                                    dashLength = 8.dp,
                                    gapLength = 4.dp,
                                    cornerRadius = 3.dp
                                )

                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "AJI76GH",
                                modifier = Modifier.align(Alignment.Center),
                                color = colorResource(id = R.color.blue),
                                fontSize = 14.sp
                            )
                        }

                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = "Expire 20 Sept",
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.Medium
                        )

                    }
                }
            }
        }
    }

}
