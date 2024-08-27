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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun About() {
    val desc = "This is a very long text that needs to be truncated and expanded with a Read More feature in Jetpack Compose. This allows users to view a snippet of the text and click to expand if they want to read more. It's a useful feature for content-heavy applications."

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 10.dp, top = 10.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(top = 10.dp),
            text = "About Course",
            fontSize = 20.sp,
            color = colorResource(id = R.color.grey),
            fontWeight = FontWeight.Medium
        )

        ReadMoreText(text = desc)

        Column {
            Row(
                modifier = Modifier
                    .padding(top = 7.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Column (
                    modifier = Modifier
                        .padding(start = 6.dp)
                ){
                    Text(
                        modifier = Modifier
                            .padding(start = 0.dp),
                        text = "John Mason",
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.grey),
                        fontWeight = FontWeight.Medium
                    )
                    Row {
                        Row(
                            modifier = Modifier
                                .padding(top = 0.dp)
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
                                    .padding(start = 2.dp, end = 4.dp),
                                color = colorResource(id = R.color.grey_text),
                                fontSize = 16.sp
                            )
                        }
                        Text(
                            text = "Reviews (5.5)",
                            modifier = Modifier
                                .padding(start = 2.dp),
                            color = colorResource(id = R.color.grey_text),
                            fontSize = 16.sp
                        )
                    }
                }
            }

        }

        Text(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 4.dp),
            text = "Road Map",
            fontSize = 20.sp,
            color = colorResource(id = R.color.grey),
            fontWeight = FontWeight.Medium
        )

        Row {
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .border(
                        width = 0.dp,
                        color = colorResource(id = R.color.blue),
                        shape = RoundedCornerShape(100.dp)
                    )
                    .clip(RoundedCornerShape(100.dp))
                    .background(colorResource(id = R.color.blue))
            ) {

                Text(
                    text = "01",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(start = 6.dp, end = 6.dp),
                    color = colorResource(id = R.color.white),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(40.dp)
                    .padding(start = 8.dp)
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.grey_text),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .clip(RoundedCornerShape(30.dp))
                    .background(colorResource(id = R.color.white))
            ) {

                Text(
                    text = "Economics",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 14.dp, end = 6.dp),
                    color = colorResource(id = R.color.grey),
                    fontSize = 14.sp
                )
            }
        }
    }

}



@Composable
fun ReadMoreText(text: String, maxLines: Int = 3) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        if (expanded) {
            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 0.dp, end = 10.dp)
                    .clickable { expanded = !expanded },
                color = colorResource(id = R.color.grey),
                fontWeight = FontWeight.Normal
            )
        } else {
            Text(
                text = buildAnnotatedString {
                    append(text.substring(0, text.length.coerceAtMost(100)))
                    if (text.length > 100) {
                        append("... ")
                        withStyle(style = SpanStyle(color = colorResource(id = R.color.blue))) {
                            append("Read More")
                        }
                    }
                },
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                modifier = Modifier
                    .clickable { expanded = !expanded }
                    .padding(top = 0.dp, end = 10.dp),


            )
        }
    }
}
