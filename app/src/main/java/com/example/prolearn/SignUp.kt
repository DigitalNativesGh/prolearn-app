package com.example.prolearn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme

class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface {
                    SignUpForm(context = this)
                }
            }
        }
    }
}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpForm(context: Context) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isTermsChecked by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
            .verticalScroll(scrollState),
    verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        Surface( ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

                ){
                Box (
                    contentAlignment = Alignment.Center
                ){
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = stringResource(id = R.string.sign_up),
                            color = colorResource(id = R.color.black),
                            modifier = Modifier
                                .padding(top = 40.dp),
                            fontWeight = FontWeight.Medium,
                            fontSize = 24.sp
                        )
                        Text(
                            text = stringResource(id = R.string.sign_up_desc),
                            color = colorResource(id = R.color.grey),
                            modifier = Modifier
                                .padding(top = 15.dp),
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(70.dp))

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
                focusedIndicatorColor = colorResource(id = R.color.light_grey) ,
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
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Email",
            modifier = Modifier
                .padding(bottom = 10.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("lee@gmail.com") },
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
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Password",
            modifier = Modifier
                .padding(bottom = 10.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("******") },
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
            trailingIcon = {
                IconButton(onClick = {  }) {
                    Icon(painter = painterResource(id=R.drawable.outline_remove_red_eye_24),
                        contentDescription ="password" )
                }
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Confirm Password",
            modifier = Modifier
                .padding(bottom = 10.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("******") },
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
            trailingIcon = {
                IconButton(onClick = {  }) {
                    Icon(painter = painterResource(id=R.drawable.outline_remove_red_eye_24), contentDescription ="password" )
                }
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(16.dp))


        Spacer(modifier = Modifier.height(0.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isTermsChecked,
                onCheckedChange = { isTermsChecked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = colorResource(id = R.color.blue)
                )
            )
            ClickableText(
                text = buildAnnotatedString {
                    append("Agree with ")
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("Terms and Conditions")
                    }
                },
                onClick = { offset ->
                    if (offset >= "Agree with ".length) {
                    }
                },
                modifier = Modifier.padding(start = 2.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val intent = Intent(context, VerifyCode::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.blue),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text("Sign up")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Divider(
                color = colorResource(id = R.color.light_grey),
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )
            Text(
                text = "Or sign in with",
                modifier = Modifier.padding(horizontal = 8.dp),
                color = colorResource(id = R.color.grey),
                style = MaterialTheme.typography.bodyMedium
            )
            Divider(
                color = colorResource(id = R.color.light_grey),
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google Sign-In",
                    tint = Color.Unspecified
                )
            }
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "facebook Sign-In",
                    tint = Color.Unspecified
                )
            }
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.linkedin),
                    contentDescription = "linkedin Sign-In",
                    tint = Color.Unspecified
                )
            }


        }


        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
            ,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Already have an account? ")
            Text(
                text = "Sign in",
                color = colorResource(id = R.color.blue),
                modifier = Modifier.clickable { }
            )
        }
    }
}


