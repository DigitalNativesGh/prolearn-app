package com.example.prolearn

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme


data class OngoingCourseItemData(
    val courseImgId: Int,
    val courseTitle: String,
    val coursePrice: String,
    val courseInstructorImgId: Int,
    val courseInstructor:String,
    val rating: String,
    val courseCategory: String,
)

class OngoingCourse : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    OngoingCourseScreen()
                }

            }
        }
    }
}

@Composable
fun OngoingCourseScreen() {
    Scaffold(

    ) { paddingValues ->
        OngoingCourse(Modifier.padding(paddingValues))
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OngoingCourse(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(

    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ){


            Box (modifier = Modifier.padding(top=10.dp, bottom = 60.dp)){
                OngoingCourseVert()
            }
        }
    }
}



@Composable
fun OngoingCourseVert() {
    val items = listOf(
        OngoingCourseItemData(
            R.drawable.student_one_cover,
            "Accounting",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "4.3",
            "Business"
        ),
        OngoingCourseItemData(
            R.drawable.student_two_cover,
            "Kotlin",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "4.3",
            "Android"
        ),
        OngoingCourseItemData(
            R.drawable.student_three_cover,
            "Regulation",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "4.3",
            "Politics"
        ),
        OngoingCourseItemData(
            R.drawable.student_two_cover,
            "Accounting",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "4.3",
            "Business"
        ),
        OngoingCourseItemData(
            R.drawable.student_one_cover,
            "Accounting",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "4.3",
            "Business"
        ),
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        items.forEach { item ->
            OngoingCourseCardItem(item)
        }
    }
}


fun Modifier.dashedBorder(
    color: Color,
    strokeWidth: Dp = 1.dp,
    dashLength: Dp = 4.dp,
    gapLength: Dp = 4.dp,
    cornerRadius: Dp = 0.dp
) = this.then(
    Modifier.drawBehind {
        val stroke = Stroke(
            width = strokeWidth.toPx(),
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(dashLength.toPx(), gapLength.toPx()),
                0f
            )
        )
        drawRoundRect(
            color = color,
            size = size,
            style = stroke,
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(cornerRadius.toPx())
        )
    }
)

@Composable
fun OngoingCourseCardItem(data: OngoingCourseItemData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(start = 20.dp, top = 10.dp, end = 20.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column {
            Box {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                    ) {
                        Image(
                            painter = painterResource(id = data.courseImgId), // Replace with your image resource
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
                                text = data.courseTitle,
                                fontSize = 23.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
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
                                    text = data.courseCategory,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(start = 6.dp, end = 6.dp),
                                    color = colorResource(id = R.color.blue),
                                    fontSize = 14.sp
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
                                painter = painterResource(id = data.courseInstructorImgId),
                                contentDescription = "Profile Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                            )
                            Text(
                                modifier = Modifier
                                    .padding(start = 5.dp),
                                text = data.courseInstructor,
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey),
                                fontWeight = FontWeight.Medium
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {


                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .height(8.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(colorResource(id = R.color.light_grey))
                            ) {
                                LinearProgressIndicator(
                                    progress = 0.5f,
                                    color = colorResource(id = R.color.blue),
                                    trackColor = Color.Transparent,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(10.dp))

                                )
                            }
                            Text(
                                text = "6/10",
                                color = colorResource(id = R.color.grey),
                                fontSize = 16.sp
                            )
                        }


                    }
                }
            }

            Box(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
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
                            text = "Pass Exam To Get",
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium,

                            )

                    }
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
                            text = "Best Seller",
                            modifier = Modifier.align(Alignment.Center),
                            color = colorResource(id = R.color.blue),
                            fontSize = 14.sp
                        )
                    }






                }
            }
        }
    }
}
