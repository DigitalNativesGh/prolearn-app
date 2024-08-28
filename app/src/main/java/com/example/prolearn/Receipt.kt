package com.example.prolearn

import android.annotation.SuppressLint
import android.graphics.Bitmap
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme


class Receipt : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ReceiptScreen()
                }
            }
        }
    }
}

@Composable
fun ReceiptScreen() {
    Scaffold(

    ) { paddingValues ->
        Receipt(Modifier.padding(paddingValues))
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Receipt(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            ReceiptAppBar(
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
                ReceiptContent()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptAppBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "E-Receipt",
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
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "Share",
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
fun ReceiptContent() {



    Column {
        Row (

            verticalAlignment  = Alignment.CenterVertically

        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .padding(vertical = 10.dp, horizontal = 20.dp),

                ) {
                Image(
                    painter = painterResource(id = R.drawable.qrcode),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(130.dp)
                        .align(Alignment.Center)
                )
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
                            text = "Purchase Date",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                        Text(
                            text = "May 7, 2024| 12:00 AM",
                            fontSize = 18.sp,
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
            Text("Download E-Receipt", fontSize = 18.sp)
        }

    }

}



