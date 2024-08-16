package com.example.prolearn

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme

data class SellersCourseItemData(
    val courseImgId: Int,
    val courseTitle: String,
    val coursePrice: String,
    val courseInstructorImgId: Int,
    val courseInstructor:String,
    val courseDuration: String,
    val courseLessons: String,
)

class BestSellers : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BestSellersScreen()
                }

            }
        }
    }
}

@Composable
fun BestSellersScreen() {
    Scaffold(

    ) { paddingValues ->
        SellersScreen(Modifier.padding(paddingValues))
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SellersScreen(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            SellersAppBar(
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
                SellersCourseVert()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SellersAppBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Best Seller",
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
fun SellersCourseVert() {
    val items = listOf(
        SellersCourseItemData(
            R.drawable.student_one_cover,
            "Accounting",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "35h 30m",
            "12 lessons"
        ),
        SellersCourseItemData(
            R.drawable.student_two_cover,
            "Business",
            "$40",
            R.drawable.profile,
            "Prof. Hassan",
            "35h 30m",
            "12 lessons"
        ),
        SellersCourseItemData(
            R.drawable.student_three_cover,
            "Economics",
            "$60",
            R.drawable.profile,
            "Miss Gloria",
            "35h 30m",
            "12 lessons"
        ),
        SellersCourseItemData(
            R.drawable.student_two_cover,
            "Business",
            "$40",
            R.drawable.profile,
            "Prof. Hassan",
            "35h 30m",
            "12 lessons"
        ),
        SellersCourseItemData(
            R.drawable.student_one_cover,
            "Accounting",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "35h 30m",
            "12 lessons"
        ),
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        items.forEach { item ->
            SellersVertCardItem(item)
        }
    }
}

@Composable
fun SellersVertCardItem(data: SellersCourseItemData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(start = 20.dp, top = 10.dp, end = 20.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.width(140.dp)) {
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
                    Icon(
                        painter = painterResource(id = R.drawable.favorite),
                        contentDescription = "Favorite Icon",
                        tint = colorResource(id = R.color.grey),
                        modifier = Modifier
                            .size(24.dp)
                            .padding(0.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
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
                        .padding(top = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = data.courseDuration + data.courseLessons,
                        fontSize = 16.sp,
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
                    Text(
                        text = data.coursePrice,
                        fontSize = 23.sp,
                        color = colorResource(id = R.color.blue),
                        fontWeight = FontWeight.Medium
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.cart),
                        contentDescription = "Favorite Icon",
                        tint = colorResource(id = R.color.grey),
                        modifier = Modifier
                            .size(24.dp)
                            .padding(0.dp)
                    )
                }
            }
        }
    }
}
