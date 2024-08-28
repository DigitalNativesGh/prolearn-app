package com.example.prolearn


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Reviews() {
    val progress = 0.6f

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 10.dp, top = 10.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(top = 13.dp),
            text = "Overall Rating",
            fontSize = 20.sp,
            color = colorResource(id = R.color.grey),
            fontWeight = FontWeight.Medium
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp,)

        ){
            Row(
                modifier = Modifier
                    .padding(horizontal = 0.dp, vertical = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(

                ) {
                    Box(
                        modifier = Modifier

                    ) {

                        Text(
                            text = "4.5",
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(top = 12.dp, end = 0.dp),
                            color = colorResource(id = R.color.grey),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Box(
                        modifier = Modifier

                            .padding(start = 0.dp)

                    ) {

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(-15.dp),

                        ) {
                            var rating by remember { mutableStateOf(3) }

                            StarRating(
                                rating = rating,
                                onRatingChanged = { newRating ->
                                    rating = newRating
                                }
                            )
                            Text(
                                text = "Based on 50 review",
                                modifier = Modifier
                                    .padding(start = 12.dp),
                                color = colorResource(id = R.color.grey_text),
                                fontSize = 14.sp
                            )
                        }
                    }
                }


            }
        }

        Column(

            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 0.dp),
                        text = "Excellent",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.grey),
                        fontWeight = FontWeight.Normal
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        LinearProgressIndicator(
                            progress = progress,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = Color.Blue,
                            trackColor = Color.Gray.copy(alpha = 0.5f)
                        )

                    }
                }
            }
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 0.dp),
                        text = "Good",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.grey),
                        fontWeight = FontWeight.Normal
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        LinearProgressIndicator(
                            progress = progress,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = Color.Blue,
                            trackColor = Color.Gray.copy(alpha = 0.4f)
                        )

                    }
                }
            }
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 0.dp),
                        text = "Average",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.grey),
                        fontWeight = FontWeight.Normal
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        LinearProgressIndicator(
                            progress = progress,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = Color.Blue,
                            trackColor = Color.Gray.copy(alpha = 0.25f)
                        )

                    }
                }
            }
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 0.dp),
                        text = "Below Average",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.grey),
                        fontWeight = FontWeight.Normal
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        LinearProgressIndicator(
                            progress = progress,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = Color.Blue,
                            trackColor = Color.Gray.copy(alpha = 0.2f)
                        )

                    }
                }
            }
        }

    }

}



@Composable
fun StarRating(
    rating: Int,
    modifier: Modifier = Modifier,
    maxRating: Int = 5,
    onRatingChanged: (Int) -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(-25.dp),
    ) {
        for (i in 1..maxRating) {
            IconButton(onClick = { onRatingChanged(i) }) {
                Icon(
                    imageVector = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = if (i <= rating) "Filled Star" else "Outlined Star",
                    tint = colorResource(id = R.color.yellow),
                    modifier = Modifier.size(24.dp),

                )
            }
        }
    }
}