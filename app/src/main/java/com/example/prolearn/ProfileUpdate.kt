package com.example.prolearn

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
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme

class ProfileUpdate : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface {
                    TopBarWithBackArrow {
                    }
                    ProfileUpdateForm(context = this)

                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithBackArrow(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(56.dp)
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Back"
            )
        }
        Text(
            text = "Complete Profile",
            style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center),

            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileUpdateForm(context: Context) {
    var username by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }
    val items = listOf("Male", "Female")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {


        Text(
            text = "Don't worry only you can see your personal data",
            style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Center),

            modifier = Modifier
                .padding(top = 50.dp, bottom = 20.dp, start = 20.dp, end = 20.dp),


        )
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
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
                        .align(Alignment.BottomEnd)
                        .size(26.dp)
                        .padding(4.dp)
                        .background(colorResource(id = R.color.blue), CircleShape)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.outline_edit_24),
                        contentDescription = "Edit Profile",
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(170.dp))

        Box {
            Column {
                Text(
                    text = "Name",
                    modifier = Modifier
                        .padding(bottom = 10.dp),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
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
        
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Phone Number",
            modifier = Modifier
                .padding(bottom = 10.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("MobileNumber") },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .height(55.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = colorResource(id = R.color.light_grey) ,
                unfocusedIndicatorColor = colorResource(id = R.color.light_grey),
                disabledIndicatorColor = colorResource(id = R.color.light_grey),
            ),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
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
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                val intent = Intent(context, Dashboard::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.blue),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text("Complete Profile")
        }
        Spacer(modifier = Modifier.height(16.dp))

    }


}

