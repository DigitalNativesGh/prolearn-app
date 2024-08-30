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
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme


class Point : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    PointScreen()
                }
            }
        }
    }
}

@Composable
fun PointScreen() {
    Scaffold(

    ) { paddingValues ->
        PointAccumulated(Modifier.padding(paddingValues))
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PointAccumulated(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            PointAppBar(
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
                PointContent()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PointAppBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Points",
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
                    painter = painterResource(id = R.drawable.clock ),
                    contentDescription = "Share",
                    tint = colorResource(id = R.color.blue)
                )
            }
            IconButton(onClick = onMoreClick) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.question_icon ),
                    contentDescription = "Share",
                    tint = colorResource(id = R.color.light_blue)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.white)
        )
    )
}



@Composable
fun PointContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment  = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
        ){
            Column {
                Box(
                    modifier = Modifier
                        .padding(top = 25.dp,)
                        .border(
                            width = 0.dp,
                            color = colorResource(id = R.color.light_grey),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .clip(RoundedCornerShape(0.dp))
                        .background(colorResource(id = R.color.light_blue))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 40.dp, bottom = 10.dp, top = 25.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.storage),
                                contentDescription = "",
                                tint = colorResource(id = R.color.grey)

                            )

                            Text(
                                text = "YOUR BALANCE",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Text(
                            text = "2000",
                            fontSize = 20.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(top = 5.dp,)
                        .border(
                            width = 0.dp,
                            color = colorResource(id = R.color.light_grey),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .clip(RoundedCornerShape(0.dp))
                        .background(colorResource(id = R.color.light_blue))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 50.dp, end = 50.dp, bottom = 10.dp, top = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){


                            Text(
                                text = "200 pending",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey_text),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Text(
                            text = "1500 available",
                            fontSize = 20.sp,
                            color = colorResource(id = R.color.grey_text),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }

                PointTabScreen()
            }
        }


    }

}



