package com.example.prolearn

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.prolearn.ui.theme.ProlearnTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CourseDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
               Surface {
                   StackedBoxes()
               }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailAppBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    TopAppBar(
        title = {

        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    modifier = Modifier
                        .size(40.dp),
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = colorResource(id = R.color.white)
                )
            }
        },
        actions = {
            IconButton(onClick = onSearchClick) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "cart",
                    tint = colorResource(id = R.color.white)
                )
            }
            IconButton(onClick = onMoreClick) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.favorite),
                    contentDescription = "Notification",
                    tint = colorResource(id = R.color.white)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent
        )
    )
}


@Composable
fun StackedBoxes() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(16.dp))
            .background(colorResource(id = R.color.light_grey))

    ) {

        Image(
            painter = painterResource(id = R.drawable.student_one_cover),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        CourseDetailAppBar(
            onBackClick = {},
            onSearchClick = {},
            onMoreClick = {}
        )

        Box (
            modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxWidth()
                .height(300.dp)


        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(18.dp))
                    .background(colorResource(id = R.color.grey))
                    .padding(vertical = 10.dp, horizontal = 20.dp)
                    .align(Alignment.Center)



            ) {
                Row {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "cart",
                        tint = colorResource(id = R.color.white)
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        text = "Course Preview",
                        fontSize = 20.sp,
                        color = Color.White,
                    )
                }
            }
        }
        Box (
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(650.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(colorResource(id = R.color.white))
        ){
            DetailTabScreen()
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(colorResource(id = R.color.white)),

            )
            {
                Row (
                    modifier = Modifier
                        .drawBehind {
                            // Draw the top border
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, 0f),
                                end = Offset(size.width, 0f),
                                strokeWidth = 0.5.dp.toPx()
                            )
                        }
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 10.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 0.dp),
                            text = "Total price",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.grey),
                            fontWeight = FontWeight.Medium
                        )

                        Text(
                            text = "$100",
                            modifier = Modifier
                                .padding(start = 2.dp),
                            color = colorResource(id = R.color.blue),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.blue),
                        ),
                        modifier = Modifier
                            .width(200.dp)
                            .height(60.dp)
                            .padding(top = 10.dp, end = 16.dp)
                    ) {
                        Text("Enroll Now",
                        )
                    }
                }
            }
        }



        @Composable
        fun BoxWithTopElevation(
            modifier: Modifier = Modifier,
            elevationColor: Color = Color.Gray,
            elevationHeight: Dp = 8.dp,
            shape: Shape = RoundedCornerShape(0.dp)
        ) {
            Box(
                modifier = modifier
                    .drawBehind {
                      drawRect(
                            brush = Brush.verticalGradient(
                                colors = listOf(elevationColor, Color.Transparent),
                                startY = 0f,
                                endY = elevationHeight.toPx()
                            ),
                            size = size.copy(height = elevationHeight.toPx())
                        )
                    }
                    .background(Color.White, shape = shape)
            )
        }



    }
}
