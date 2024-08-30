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


class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    Scaffold(

    ) { paddingValues ->
        ProfileList(Modifier.padding(paddingValues))
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileList(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            ProfileAppBar(
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
                ProfileContent()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileAppBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Profile",
                fontSize = 23.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.grey),
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Medium

            )
        },

        actions = {

            IconButton(onClick = onMoreClick) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.moon ),
                    contentDescription = "Share",
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
fun ProfileContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment  = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment  = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Center
        ){
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,

                ) {
                // Profile Image
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                )

                IconButton(
                    onClick = {  },
                    modifier = Modifier
                        .clip(RoundedCornerShape(80.dp))
                        .size(30.dp)
                        .background(colorResource(id = R.color.blue))
                        .padding(4.dp)
                        .align(Alignment.BottomEnd)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(20.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.outline_edit_24),
                        contentDescription = "Edit Profile",
                        tint = colorResource(id = R.color.white)

                    )
                }
            }
        }

        Text(
            text = "Prof. Hassan",
            fontSize = 20.sp,
            color = colorResource(id = R.color.grey),
            fontWeight = FontWeight.SemiBold,

            )

        Text(
            text = "profhassan@gmail.com",
            fontSize = 18.sp,
            color = colorResource(id = R.color.grey_text),
            fontWeight = FontWeight.SemiBold,

            )

        Row (
            modifier = Modifier
                .padding(top = 20.dp, end = 20.dp, start = 20.dp)
        ){
            Divider(
                color = colorResource(id = R.color.light_grey),
                modifier = Modifier
                    .height(1.dp)
            )
        }


        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
        ){
            Column {
                Box(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 40.dp, end = 40.dp, top = 5.dp),
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
                                color = colorResource(id = R.color.blue),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Text(
                            text = "2000",
                            fontSize = 20.sp,
                            color = colorResource(id = R.color.blue),
                            fontWeight = FontWeight.SemiBold,

                            )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                            ){
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.person),
                                contentDescription = "",
                                tint = colorResource(id = R.color.grey)

                            )

                            Text(
                                text = "Edit Profile",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey_text),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Icon(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = colorResource(id = R.color.blue)

                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.notification_icon),
                                contentDescription = "",
                                tint = colorResource(id = R.color.grey)

                            )

                            Text(
                                text = "Notification",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey_text),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Icon(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = colorResource(id = R.color.blue)

                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.payment),
                                contentDescription = "",
                                tint = colorResource(id = R.color.grey)

                            )

                            Text(
                                text = "Payment",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey_text),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Icon(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = colorResource(id = R.color.blue)

                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.language),
                                contentDescription = "",
                                tint = colorResource(id = R.color.grey)

                            )

                            Text(
                                text = "Language",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey_text),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Icon(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = colorResource(id = R.color.blue)

                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.help),
                                contentDescription = "",
                                tint = colorResource(id = R.color.grey)

                            )

                            Text(
                                text = "Help Center",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey_text),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Icon(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = colorResource(id = R.color.blue)

                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.settings),
                                contentDescription = "",
                                tint = colorResource(id = R.color.grey)

                            )

                            Text(
                                text = "Setting",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey_text),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Icon(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = colorResource(id = R.color.blue)

                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.help),
                                contentDescription = "",
                                tint = colorResource(id = R.color.grey)

                            )

                            Text(
                                text = "Video Preference",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey_text),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Icon(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = colorResource(id = R.color.blue)

                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.invite_friends),
                                contentDescription = "",
                                tint = colorResource(id = R.color.grey)

                            )

                            Text(
                                text = "Invite Friends",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey_text),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                        Icon(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = colorResource(id = R.color.blue)

                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 20.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.logout),
                                contentDescription = "",
                                tint = colorResource(id = R.color.red)

                            )

                            Text(
                                text = "Log Out",
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.grey_text),
                                fontWeight = FontWeight.SemiBold,

                                )
                        }

                    }
                }

            }
        }


    }

}



