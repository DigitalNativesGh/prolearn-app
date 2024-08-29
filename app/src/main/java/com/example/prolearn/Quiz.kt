package com.example.prolearn

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme


class Quiz : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    QuizScreen()
                }
            }
        }
    }
}

@Composable
fun QuizScreen() {
    Scaffold(

    ) { paddingValues ->
        Quizzes(Modifier.padding(paddingValues))
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quizzes(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            QuizAppBar(
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
                QuizContent()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizAppBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Quiz",
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
            IconButton(onClick = onSearchClick) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = "cart",
                    tint = colorResource(id = R.color.grey)
                )
            }
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
fun QuizContent() {

    Column (

    ){


        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                question()
            }

        }


    }

}







@Composable
fun QuizProgressBar(
    currentQuestion: Int,
    totalQuestions: Int,
    colors: List<Color>,
    segmentGap: Float = 50f,
    strokeWidth: Float = 20f
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(strokeWidth.dp)
    ) {
        val segmentWidth = (size.width - (segmentGap * (totalQuestions - 1))) / totalQuestions

        for (i in 0 until totalQuestions) {
            val color = if (i < currentQuestion) colors[i % colors.size] else Color.Gray
            val startX = i * (segmentWidth + segmentGap)

            drawLine(
                color = color,
                start = androidx.compose.ui.geometry.Offset(x = startX, y = center.y),
                end = androidx.compose.ui.geometry.Offset(x = startX + segmentWidth, y = center.y),
                strokeWidth = strokeWidth,
                cap = StrokeCap.Round
            )
        }
    }
}

@Composable
fun question() {
    var currentQuestion by remember { mutableStateOf(0) }
    val totalQuestions = 5
    val colors = listOf(colorResource(id = R.color.green),)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))


        QuizProgressBar(
            currentQuestion = currentQuestion,
            totalQuestions = totalQuestions,
            colors = colors
        )

        Text(
            text = "what the purpose of accounting?",
            modifier = Modifier
                .padding(top = 30.dp, bottom = 50.dp),
            style = TextStyle(
                fontSize= 18.sp,
                fontWeight = FontWeight.Medium
            )
        )

        Column {
            Box {
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.white),
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .height(55.dp)
                        .border(
                            width = 1.dp,
                            color = colorResource(id = R.color.grey),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clip(RoundedCornerShape(100.dp))
                        .background(colorResource(id = R.color.grey))

                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            "Answer",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey)
                        )
                    }
                }
            }
            Box {
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.white),
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .height(55.dp)
                        .border(
                            width = 1.dp,
                            color = colorResource(id = R.color.grey),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clip(RoundedCornerShape(100.dp))
                        .background(colorResource(id = R.color.grey))

                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            "Answer",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey)
                        )
                    }
                }
            }
            Box {
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.white),
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .height(55.dp)
                        .border(
                            width = 1.dp,
                            color = colorResource(id = R.color.grey),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clip(RoundedCornerShape(100.dp))
                        .background(colorResource(id = R.color.grey))

                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            "Answer",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey)
                        )
                    }
                }
            }
            Box {
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.white),
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .height(55.dp)
                        .border(
                            width = 1.dp,
                            color = colorResource(id = R.color.grey),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clip(RoundedCornerShape(100.dp))
                        .background(colorResource(id = R.color.grey))

                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            "Answer",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
        ) {
            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.white),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 80.dp, end = 20.dp)
                    .height(55.dp)
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.blue),
                        shape = RoundedCornerShape(100.dp)
                    )
                    .clip(RoundedCornerShape(100.dp))
                    .background(colorResource(id = R.color.blue))
            ) {
                Text("Previous",
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.blue)
                )
            }


            Button(
                onClick = {
                    if (currentQuestion < totalQuestions) {
                        currentQuestion++
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.blue),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 80.dp, start = 20.dp)
                    .height(55.dp)
            ) {
                Text("Finish", fontSize = 18.sp)
            }
        }

    }
}
