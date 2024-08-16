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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme

data class SearchCourseItemData(
    val courseImgId: Int,
    val courseTitle: String,
    val coursePrice: String,
    val courseInstructorImgId: Int,
    val courseInstructor:String,
    val rating: String,
    val PreviousPrice: String,
)

class Search : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SearchScreen()
                }

            }
        }
    }
}

@Composable
fun SearchScreen() {
    Scaffold(
    ) { paddingValues ->
        Column {
            Search(Modifier.padding(paddingValues))

        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ){
            Box(modifier = Modifier.padding(top = 20.dp)) {
                Row(
                    modifier = Modifier
                        .padding(it)
                )
                {
                    OutlinedTextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp, start = 16.dp),
                        placeholder = {
                            Text(text = "ui/ux design")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "search by speaking",
                                tint = Color.Gray
                            )
                        },
                        trailingIcon = {
                            Icon(
                                modifier = Modifier
                                    .size(20.dp),
                                painter = painterResource(id = R.drawable.filter),
                                contentDescription = "search by speaking",
                                tint = Color.Gray
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = colorResource(id = R.color.light_grey),
                            unfocusedIndicatorColor = colorResource(id = R.color.light_grey),
                            disabledIndicatorColor = colorResource(id = R.color.light_grey),
                        ),
                        shape = RoundedCornerShape(10.dp),
                    )
                    IconButton(onClick = { }) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .size(24.dp),
                            painter = painterResource(id = R.drawable.voice_microphone),
                            contentDescription = "Filter",
                            tint = colorResource(id = R.color.grey)
                        )
                    }
                }
            }

            SearchCourseVert()
        }
    }

}




@Composable
fun SearchCourseVert() {
    val items = listOf(
        SearchCourseItemData(
            R.drawable.student_one_cover,
            "Accounting",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "4.3",
            "70"
        ),
        SearchCourseItemData(
            R.drawable.student_two_cover,
            "Business",
            "$40",
            R.drawable.profile,
            "Prof. Hassan",
            "3.2",
            "60"
        ),
        SearchCourseItemData(
            R.drawable.student_three_cover,
            "Economics",
            "$60",
            R.drawable.profile,
            "Miss Gloria",
            "5",
            "76"
        ),
        SearchCourseItemData(
            R.drawable.student_two_cover,
            "Business",
            "$40",
            R.drawable.profile,
            "Prof. Hassan",
            "5",
            "65"
        ),
        SearchCourseItemData(
            R.drawable.student_one_cover,
            "Accounting",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "5",
            "90"
        ),
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        items.forEach { item ->
            SearchVertCardItem(item)
        }
    }
}

@Composable
fun SearchVertCardItem(data: SearchCourseItemData) {
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
                    Row(modifier = Modifier
                        .padding(top = 6.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Favorite Icon",
                            tint = colorResource(id = R.color.yellow),
                            modifier = Modifier
                                .size(18.dp)
                                .padding(0.dp)
                        )
                        Text(
                            text = data.rating,
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
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row {
                        Text(
                            text = data.coursePrice,
                            fontSize = 23.sp,
                            color = colorResource(id = R.color.blue),
                            fontWeight = FontWeight.Medium,

                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = data.PreviousPrice,
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
}
