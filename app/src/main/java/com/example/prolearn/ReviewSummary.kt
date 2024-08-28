package com.example.prolearn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme


class ReviewSummary : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ReviewSummaryScreen()
                }

            }
        }
    }
}

@Composable
fun ReviewSummaryScreen() {
    Scaffold(

    ) { paddingValues ->
        ReviewScreen(Modifier.padding(paddingValues))
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewScreen(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            ReviewAppBar(
                onBackClick = {},
                onSearchClick = {  },
                onMoreClick = {  }
            )
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ){


            Box (modifier = Modifier.padding(top=100.dp, bottom = 60.dp)){
                ReviewSummaryItem()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewAppBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Review Summary",
                fontSize = 23.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.grey),
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Medium

            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    modifier = Modifier
                        .size(40.dp),
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = colorResource(id = R.color.grey)
                )
            }
        },
        actions = {

            IconButton(onClick = onMoreClick) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.notification_icon),
                    contentDescription = "Notification",
                    tint = colorResource(id = R.color.grey)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.white)
        )
    )
}



@Composable
fun ReviewSummaryItem() {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(start = 20.dp, top = 10.dp, end = 20.dp),
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
                        .padding(start = 15.dp, end = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Accounting",
                            fontSize = 23.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
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
                            text = "Prof. Hassan",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row {
                            Text(
                                text = "$80",
                                fontSize = 23.sp,
                                color = colorResource(id = R.color.blue),
                                fontWeight = FontWeight.Medium,

                                )
                            Text(
                                modifier = Modifier
                                    .padding(start = 5.dp),
                                text = "9$0",
                                fontSize = 23.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium,
                                textDecoration = TextDecoration.LineThrough
                            )
                        }
                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(30.dp)
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.yellow),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clip(RoundedCornerShape(16.dp))
                                .background(colorResource(id = R.color.yellow))
                        ) {

                            Text(
                                text = "Best Seller",
                                modifier = Modifier.align(Alignment.Center),
                                color = colorResource(id = R.color.black),
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }


        Box(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 8.dp)
                .dashedBorder(
                    color = colorResource(id = R.color.green),
                    strokeWidth = 2.dp,
                    dashLength = 8.dp,
                    gapLength = 4.dp,
                    cornerRadius = 3.dp
                )
                .clip(RoundedCornerShape(6.dp))
                .background(colorResource(id = R.color.white))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row {
                    Text(
                        text = "Your balance",
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.grey),
                        fontWeight = FontWeight.Medium,

                        )

                }
                Box(
                    modifier = Modifier
                        .width(120.dp)
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
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = "Favorite Icon",
                            tint = colorResource(id = R.color.blue),
                            modifier = Modifier
                                .size(16.dp)
                                .padding(end = 4.dp)
                        )
                        Text(
                            text = "00000 = ",
                            modifier = Modifier
                                .padding(),
                            color = colorResource(id = R.color.grey),
                            fontSize = 14.sp
                        )
                        Text(
                            text = "$0",
                            modifier = Modifier
                                .padding(),
                            color = colorResource(id = R.color.blue),
                            fontSize = 14.sp
                        )
                    }
                }






            }
        }

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
        ){
            Column {
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Instructor",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                        Text(
                            text = "Prof. Hassan",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Language",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                        Text(
                            text = "English",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Lessons",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                        Text(
                            text = "25",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }


                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Level",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                        Text(
                            text = "Beginner",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }

            }
        }
        Row (
            modifier = Modifier
                .padding(top = 10.dp, end = 20.dp, start = 20.dp)
        ){
            Divider(
                color = colorResource(id = R.color.light_grey),
                modifier = Modifier
                    .height(1.dp)
            )
        }

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
        ){
            Column {
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Amount",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                        Text(
                            text = "100",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Changing points",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                        Text(
                            text = "0",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Total",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                        Text(
                            text = "$80",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }


            }

        }

        Row (
            modifier = Modifier
                .padding(top = 10.dp, end = 20.dp, start = 20.dp)
        ){
            Divider(
                color = colorResource(id = R.color.light_grey),
                modifier = Modifier
                    .height(1.dp)
            )
        }

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
        ){
            Column {
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Payment Methods",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                        Text(
                            text = "credit",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Payment Status",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                        Text(
                            text = "paid",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }







            }

        }
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.blue),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, start = 20.dp, end = 20.dp)
                .height(55.dp)
        ) {
            Text("Pay Now")
        }
        
    }
}


