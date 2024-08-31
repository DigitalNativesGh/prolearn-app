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
fun Redeem() {

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

                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                text = "10% off your next course",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }

                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(end = 0.dp),
                                painter = painterResource(id = R.drawable.lock_icon),
                                contentDescription = "",
                                tint = colorResource(id = R.color.blue)

                            )
                            Column (
                                modifier = Modifier

                                    .width(200.dp)
                                    .padding(end = 10.dp)
                            ){
                                Text(
                                    modifier = Modifier
                                        .padding(start = 5.dp, ),
                                    text = "Coupon Unlock",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.grey),
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(start = 5.dp, ),
                                    text = "Pass exam for your first course to get it",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.grey),
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                text = "Redeem for 200",
                                fontSize = 16.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }

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

                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                text = "10% off your next course",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }

                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(end = 0.dp),
                                painter = painterResource(id = R.drawable.lock_icon),
                                contentDescription = "",
                                tint = colorResource(id = R.color.blue)

                            )
                            Column (
                                modifier = Modifier

                                    .width(200.dp)
                                    .padding(end = 10.dp)
                            ){
                                Text(
                                    modifier = Modifier
                                        .padding(start = 5.dp, ),
                                    text = "Coupon Unlock",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.grey),
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(start = 5.dp, ),
                                    text = "Pass exam for your first course to get it",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.grey),
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                text = "Redeem for 200",
                                fontSize = 16.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }

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

                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                text = "10% off your next course",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }

                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(end = 0.dp),
                                painter = painterResource(id = R.drawable.lock_icon),
                                contentDescription = "",
                                tint = colorResource(id = R.color.blue)

                            )
                            Column (
                                modifier = Modifier

                                    .width(200.dp)
                                    .padding(end = 10.dp)
                            ){
                                Text(
                                    modifier = Modifier
                                        .padding(start = 5.dp, ),
                                    text = "Coupon Unlock",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.grey),
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(start = 5.dp, ),
                                    text = "Pass exam for your first course to get it",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.grey),
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                text = "Redeem for 200",
                                fontSize = 16.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }

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

                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                text = "10% off your next course",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }

                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(end = 0.dp),
                                painter = painterResource(id = R.drawable.lock_icon),
                                contentDescription = "",
                                tint = colorResource(id = R.color.blue)

                            )
                            Column (
                                modifier = Modifier

                                    .width(200.dp)
                                    .padding(end = 10.dp)
                            ){
                                Text(
                                    modifier = Modifier
                                        .padding(start = 5.dp, ),
                                    text = "Coupon Unlock",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.grey),
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(start = 5.dp, ),
                                    text = "Pass exam for your first course to get it",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.grey),
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                text = "Redeem for 200",
                                fontSize = 16.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }

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

                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                text = "10% off your next course",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }

                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(end = 0.dp),
                                painter = painterResource(id = R.drawable.lock_icon),
                                contentDescription = "",
                                tint = colorResource(id = R.color.blue)

                            )
                            Column (
                                modifier = Modifier

                                    .width(200.dp)
                                    .padding(end = 10.dp)
                            ){
                                Text(
                                    modifier = Modifier
                                        .padding(start = 5.dp, ),
                                    text = "Coupon Unlock",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.grey),
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(start = 5.dp, ),
                                    text = "Pass exam for your first course to get it",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.grey),
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clip(RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.light_blue))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                text = "Redeem for 200",
                                fontSize = 16.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }

                    }
                }
            }
        }




    }

}
