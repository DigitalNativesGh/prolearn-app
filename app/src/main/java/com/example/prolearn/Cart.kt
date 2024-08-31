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


class Cart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    CartScreen()
                }

            }
        }
    }
}

@Composable
fun CartScreen() {
    Scaffold(

    ) { paddingValues ->
        CartsScreen(Modifier.padding(paddingValues))
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartsScreen(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CartAppBar(
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
                CartsContent()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartAppBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Cart",
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
fun CartsContent() {
    Column {

        Text(
            text = "1 Items",
            fontSize = 23.sp,
            color = colorResource(id = R.color.grey),
            fontWeight = FontWeight.Medium
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
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
                                painter = painterResource(id = R.drawable.favorite),
                                contentDescription = "Favorite Icon",
                                tint = colorResource(id = R.color.grey),
                                modifier = Modifier
                                    .size(18.dp)
                                    .padding(0.dp)
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
                    Text(
                        modifier = Modifier
                            .padding(start = 5.dp),
                        text = "2h 15m - 25 lessons",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.grey),
                        fontWeight = FontWeight.Normal
                    )

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

                        }
                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(30.dp)
                                .border(
                                    width = 0.dp,
                                    color = colorResource(id = R.color.blue),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clip(RoundedCornerShape(16.dp))
                                .background(colorResource(id = R.color.blue))
                        ) {

                            Text(
                                text = "Enroll Now",
                                modifier = Modifier.align(Alignment.Center),
                                color = colorResource(id = R.color.white),
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }

    }
}


