package com.example.prolearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme

data class CourseItemData(
    val courseImgId: Int,
    val courseTitle: String,
    val coursePrice: String,
    val courseInstructorImgId: Int,
    val courseInstructor:String,
    val courseDuration: String,
    val courseLessons: String,
)

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    DashboardScreen()
                }

            }
        }
    }
}

@Composable
fun DashboardScreen() {
    Scaffold(
        bottomBar = { NavigationBar() }
    ) { paddingValues ->
        CustomAppBarScreen(Modifier.padding(paddingValues))
    }
}


@Composable
fun NavigationBar() {
    var selectedIndex by remember { mutableStateOf(0) }
    NavigationBar(
        containerColor = colorResource(id = R.color.white),

    ) {
        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = { selectedIndex = 1 },
            icon = {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = if (selectedIndex == 1) Color.White else Color.Transparent,
                            shape = androidx.compose.foundation.shape.CircleShape
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.home_icon),
                        contentDescription = "Home",
                    )
                }
            },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = colorResource(id = R.color.blue),
                selectedTextColor =colorResource(id = R.color.blue),
                unselectedIconColor = colorResource(id = R.color.grey),
                unselectedTextColor = colorResource(id = R.color.grey),
                indicatorColor = colorResource(id = R.color.white)
            )
        )
        NavigationBarItem(
            selected = selectedIndex == 0,
            onClick = { selectedIndex = 0 },
            icon = {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = if (selectedIndex == 1) Color.White else Color.Transparent,
                            shape = androidx.compose.foundation.shape.CircleShape
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search",
                    )
                }
                   },
            label = { Text("Search") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = colorResource(id = R.color.blue),
                selectedTextColor =colorResource(id = R.color.blue),
                unselectedIconColor = colorResource(id = R.color.grey),
                unselectedTextColor = colorResource(id = R.color.grey),
                indicatorColor = colorResource(id = R.color.white)
            )
        )
        NavigationBarItem(
            selected = selectedIndex == 2,
            onClick = { selectedIndex = 2 },
            icon = {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = if (selectedIndex == 1) Color.White else Color.Transparent,
                            shape = androidx.compose.foundation.shape.CircleShape
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.book),
                        contentDescription = "My Course",
                    )
                }
                   },
            label = { Text("My Course") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = colorResource(id = R.color.blue),
                selectedTextColor =colorResource(id = R.color.blue),
                unselectedIconColor = colorResource(id = R.color.grey),
                unselectedTextColor = colorResource(id = R.color.grey),
                indicatorColor = colorResource(id = R.color.white)
            )
        )
        NavigationBarItem(
            selected = selectedIndex == 3,
            onClick = { selectedIndex = 3 },
            icon = {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = if (selectedIndex == 1) Color.White else Color.Transparent,
                            shape = androidx.compose.foundation.shape.CircleShape
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.favorite),
                        contentDescription = "Wishlist",
                    )
                }
            },
            label = { Text("Wishlist") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = colorResource(id = R.color.blue),
                selectedTextColor =colorResource(id = R.color.blue),
                unselectedIconColor = colorResource(id = R.color.grey),
                unselectedTextColor = colorResource(id = R.color.grey),
                indicatorColor = colorResource(id = R.color.white)
            )
        )
        NavigationBarItem(
            selected = selectedIndex == 4,
            onClick = { selectedIndex = 4 },
            icon = {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = if (selectedIndex == 1) Color.White else Color.Transparent,
                            shape = androidx.compose.foundation.shape.CircleShape
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "Home",
                    )
                }
            },
            label = { Text("Profile") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = colorResource(id = R.color.blue),
                selectedTextColor =colorResource(id = R.color.blue),
                unselectedIconColor = colorResource(id = R.color.grey),
                unselectedTextColor = colorResource(id = R.color.grey),
                indicatorColor = colorResource(id = R.color.white)
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBarScreen(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CustomAppBar(
                NameGreet = "Welcome Yola",
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
            Box(modifier = Modifier.padding(top = 16.dp)) {
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
                            Text(text = "What do you want to learn")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
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
            Topics()
            Course()
            CourseVert()
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    NameGreet: String,
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    TopAppBar(
        title = {
            Column {

                Text(
                    text = NameGreet,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    color = colorResource(id = R.color.grey),
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Medium,


                    )
                Text(
                    text = "Edit Goals",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    color = colorResource(id = R.color.blue),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
//        navigationIcon = {
//            IconButton(onClick = onBackClick) {
//                Icon(
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = "Back",
//                    tint = Color.White
//                )
//            }
//        },
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
                    contentDescription = "More",
                    tint = colorResource(id = R.color.grey)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.white)
        )
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topics() {
    val filters = listOf("All Topics", "Special Offers", "Best Sellers", "New Offers")
    var selectedFilter by remember { mutableStateOf(filters.first()) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(filters.size) { index ->
            val filter = filters[index]
            FilterChip(
                modifier = Modifier
                    .height(45.dp),
                selected = selectedFilter == filter,
                onClick = { selectedFilter = filter },
                label = {
                    Text(
                        text = filter,
                        style = TextStyle(
                            fontSize = 14.sp
                        )
                    )
                },
                shape = RoundedCornerShape(30.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = colorResource(id = R.color.blue),
                    selectedLabelColor = colorResource(id = R.color.white),
                    containerColor = colorResource(id = R.color.white),
                    labelColor = colorResource(id = R.color.grey)
                )
            )
        }

    }
}


@Composable
fun Course() {
    val items = listOf(
        CourseItemData(
            R.drawable.student_one_cover,
            "Accounting",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "35h 30m",
            "12 lessons"
        ),
        CourseItemData(
            R.drawable.student_two_cover,
            "Business",
            "$40",
            R.drawable.profile,
            "Prof. Hassan",
            "35h 30m",
            "12 lessons"
        ),
        CourseItemData(
            R.drawable.student_three_cover,
            "Economics",
            "$60",
            R.drawable.profile,
            "Miss Gloria",
            "35h 30m",
            "12 lessons"
        ),
    )

    LazyRow(
        contentPadding = PaddingValues(vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(items) { item ->
            CardItem(item)
        }
    }
}

@Composable
fun CardItem(data: CourseItemData) {

    Card(
        modifier = Modifier
            .width(300.dp)
            .height(290.dp)
            .padding(start = 20.dp, top = 10.dp, end = 6.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)), // Set card background color here
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.height(150.dp)) {
                Image(
                    painter = painterResource(id = data.courseImgId), // Replace with your image resource
                    contentDescription = "Course image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(6.dp))
                )
                Icon(
                    painter = painterResource(id = R.drawable.favorite),
                    contentDescription = "Favorite Icon",
                    tint = colorResource(id = R.color.white),
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.courseTitle,
                    fontSize = 23.sp,
                    color = colorResource(id = R.color.grey),
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = data.coursePrice,
                    fontSize = 23.sp,
                    color = colorResource(id = R.color.blue),
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = data.courseInstructorImgId),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)

                )
                Text(
                    modifier = Modifier
                        .padding(start = 5.dp),
                    text = data.courseInstructor,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.grey),
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.courseDuration + data.courseLessons,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.grey),
                    fontWeight = FontWeight.Medium
                )
                Image(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(22.dp)

                )
            }

        }
    }
}

@Composable
fun CourseVert() {
    val items = listOf(
        CourseItemData(
            R.drawable.student_one_cover,
            "Accounting",
            "$80",
            R.drawable.profile,
            "Prof. Hassan",
            "35h 30m",
            "12 lessons"
        ),
        CourseItemData(
            R.drawable.student_two_cover,
            "Business",
            "$40",
            R.drawable.profile,
            "Prof. Hassan",
            "35h 30m",
            "12 lessons"
        ),
        CourseItemData(
            R.drawable.student_three_cover,
            "Economics",
            "$60",
            R.drawable.profile,
            "Miss Gloria",
            "35h 30m",
            "12 lessons"
        ),
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Recommended For You",
            fontSize = 23.sp,
            color = colorResource(id = R.color.grey),
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "View all",
            fontSize = 18.sp,
            color = colorResource(id = R.color.blue),
            fontWeight = FontWeight.Medium
        )
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        items.forEach { item ->
            VertCardItem(item)
        }
    }
}

@Composable
fun VertCardItem(data: CourseItemData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(start = 20.dp, top = 10.dp, end = 6.dp),
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
