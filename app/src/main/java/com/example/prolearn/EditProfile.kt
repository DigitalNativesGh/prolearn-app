package com.example.prolearn

import android.annotation.SuppressLint

import  android.content.Context
import android.content.Intent
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme

class EditProfile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    EditProfileScreen()
                }
            }
        }
    }
}

@Composable
fun EditProfileScreen() {
    Scaffold(

    ) { paddingValues ->
        EditProfileUser(Modifier.padding(paddingValues))
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileUser(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            EditProfileAppBar(
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
                EditProfileContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileAppBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit
)  {
    TopAppBar(
        title = {
            Text(
                text = "Edit Profile",
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileContent() {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }
    val items = listOf("Male", "Female")


    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment  = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 10.dp),
            text = "Don't worry only you can see your personal data",
            fontSize = 18.sp,
            color = colorResource(id = R.color.grey_text),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center

            )
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





        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
        ){
            Column {

                Box (
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                ){
                    Column {
                        Text(
                            text = "Name",
                            modifier = Modifier
                                .padding(bottom = 10.dp),
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                        OutlinedTextField(
                            value = "" +
                                    "" +
                                    "",
                            onValueChange = {  },
                            placeholder = { Text("Lee Nee") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .height(55.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White,
                                focusedIndicatorColor = colorResource(id = R.color.light_grey),
                                unfocusedIndicatorColor = colorResource(id = R.color.light_grey),
                                disabledIndicatorColor = colorResource(id = R.color.light_grey),
                            ),
                            shape = RoundedCornerShape(10.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Email,
                                imeAction = ImeAction.Next
                            )
                        )
                    }
                }

                Box (
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                ){
                    Column {
                        Text(
                            text = "Email",
                            modifier = Modifier
                                .padding(bottom = 10.dp),
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                        OutlinedTextField(
                            value = "" +
                                    "" +
                                    "",
                            onValueChange = {  },
                            placeholder = { Text("prof@gmail.com") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .height(55.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White,
                                focusedIndicatorColor = colorResource(id = R.color.light_grey),
                                unfocusedIndicatorColor = colorResource(id = R.color.light_grey),
                                disabledIndicatorColor = colorResource(id = R.color.light_grey),
                            ),
                            shape = RoundedCornerShape(10.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Email,
                                imeAction = ImeAction.Next
                            )
                        )
                    }
                }

                Box (
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                ){
                    Column {
                        Text(
                            text = "Phone Number",
                            modifier = Modifier
                                .padding(bottom = 10.dp),
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                        OutlinedTextField(
                            value = "" +
                                    "" +
                                    "",
                            onValueChange = {  },
                            placeholder = { Text("+233 55 0045 556") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .height(55.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White,
                                focusedIndicatorColor = colorResource(id = R.color.light_grey),
                                unfocusedIndicatorColor = colorResource(id = R.color.light_grey),
                                disabledIndicatorColor = colorResource(id = R.color.light_grey),
                            ),
                            shape = RoundedCornerShape(10.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Email,
                                imeAction = ImeAction.Next
                            )
                        )
                    }
                }

                Box (
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 30.dp)
                ){
                    Column {
                        Text(
                            text = "Gender",
                            modifier = Modifier
                                .padding(bottom = 10.dp),
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = { expanded = !expanded }
                        ) {
                            OutlinedTextField(
                                value = selectedItem,
                                onValueChange = { selectedItem = it },
                                placeholder = { Text("Choose") },
                                readOnly = true,
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .menuAnchor(),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.White,
                                    focusedIndicatorColor = colorResource(id = R.color.light_grey) ,
                                    unfocusedIndicatorColor = colorResource(id = R.color.light_grey),
                                    disabledIndicatorColor = colorResource(id = R.color.light_grey),
                                ),
                                shape = RoundedCornerShape(10.dp),
                            )
                            ExposedDropdownMenu(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                items.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(text = item) },
                                        onClick = {
                                            selectedItem = item
                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                }

                Box (
                    modifier = Modifier
                        .padding(top = 40.dp)
                ){
                    Button(
                        onClick = {

                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.blue),
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .padding(start = 20.dp, end = 20.dp)
                    ) {
                        Text("Update")
                    }
                }

            }
        }


    }

}



