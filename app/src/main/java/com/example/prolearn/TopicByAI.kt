package com.example.prolearn

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme


class TopicByAI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                        ,
                ) {
                    TopicByAIScreen()
                }
            }
        }
    }
}

@Composable
fun TopicByAIScreen() {
    Scaffold(

    ) { paddingValues ->
        TopicBy(
            Modifier
                .padding(paddingValues)

        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicBy(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(

        topBar = {
            TopicByAppBar(

                onBackClick = {},
                onSearchClick = {  },
                onMoreClick = {  }

            )
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F4F4))
                .verticalScroll(scrollState)
        ){


            Box (modifier = Modifier.padding(top=100.dp, bottom = 60.dp)){
                TopicByAIContent()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicByAppBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit,

) {
    TopAppBar(
        title = {
            Text(
                text = "Cut Topic By AI",
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


        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFFF5F4F4)
        )
    )
}



@Composable
fun TopicByAIContent() {


    Column {
        Box {
            Column {
                Box(
                    modifier = Modifier
                        .background(Color(0xffffffff)),


                    ) {
                    Column {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp),
                            text = "First Topic",
                            fontSize = 25.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center

                        )
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.student_one_cover),
                                contentDescription = "Background Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .fillMaxHeight()
                                    .background(colorResource(id = R.color.grey))
                                    .padding(4.dp)
                                    .align(Alignment.Center)

                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(40.dp),
                                    painter = painterResource(id = R.drawable.play_outline),
                                    contentDescription = "",
                                    tint = colorResource(id = R.color.white)
                                )
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
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row {
                            Text(
                                text = "8 Point Grid",
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
                                .clip(RoundedCornerShape(6.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {

                                Text(
                                    text = "00:00 - ",
                                    modifier = Modifier
                                        .padding(),
                                    color = colorResource(id = R.color.grey),
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = "10:00",
                                    modifier = Modifier
                                        .padding(),
                                    color = colorResource(id = R.color.green),
                                    fontSize = 14.sp
                                )
                            }
                        }


                    }
                }

            }
        }
        Box {
            Column {
                Box(
                    modifier = Modifier
                        .background(Color(0xffffffff)),


                    ) {
                    Column {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp),
                            text = "First Topic",
                            fontSize = 25.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center

                        )
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.student_two_cover),
                                contentDescription = "Background Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .fillMaxHeight()
                                    .background(colorResource(id = R.color.grey))
                                    .padding(4.dp)
                                    .align(Alignment.Center)

                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(40.dp),
                                    painter = painterResource(id = R.drawable.play_outline),
                                    contentDescription = "",
                                    tint = colorResource(id = R.color.white)
                                )
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
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row {
                            Text(
                                text = "8 Point Grid",
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
                                .clip(RoundedCornerShape(6.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {

                                Text(
                                    text = "00:00 - ",
                                    modifier = Modifier
                                        .padding(),
                                    color = colorResource(id = R.color.grey),
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = "10:00",
                                    modifier = Modifier
                                        .padding(),
                                    color = colorResource(id = R.color.green),
                                    fontSize = 14.sp
                                )
                            }
                        }


                    }
                }

            }
        }
        Box {
            Column {
                Box(
                    modifier = Modifier
                        .background(Color(0xffffffff)),


                    ) {
                    Column {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp),
                            text = "First Topic",
                            fontSize = 25.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center

                        )
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.student_three_cover),
                                contentDescription = "Background Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .fillMaxHeight()
                                    .background(colorResource(id = R.color.grey))
                                    .padding(4.dp)
                                    .align(Alignment.Center)

                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(40.dp),
                                    painter = painterResource(id = R.drawable.play_outline),
                                    contentDescription = "",
                                    tint = colorResource(id = R.color.white)
                                )
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
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row {
                            Text(
                                text = "8 Point Grid",
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
                                .clip(RoundedCornerShape(6.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {

                                Text(
                                    text = "00:00 - ",
                                    modifier = Modifier
                                        .padding(),
                                    color = colorResource(id = R.color.grey),
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = "10:00",
                                    modifier = Modifier
                                        .padding(),
                                    color = colorResource(id = R.color.green),
                                    fontSize = 14.sp
                                )
                            }
                        }


                    }
                }

            }
        }
    }

}



