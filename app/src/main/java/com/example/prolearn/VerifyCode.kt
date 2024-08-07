package com.example.prolearn
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

class VerifyCode : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface {
                    VerifyCode(name = "verify")
                    VerifyCodeForm(context = this)
                }
            }
        }
    }
}

@Composable
fun VerifyCode(name: String, modifier: Modifier = Modifier) {

    Surface( modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.verify),
                color = colorResource(id = R.color.black),
                modifier = Modifier
                    .padding(top = 40.dp),
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp
            )
            Text(
                text = stringResource(id = R.string.verifyDesc),
                color = colorResource(id = R.color.grey),
                modifier = Modifier
                    .padding(top = 15.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,

                )
            Text(
                text = stringResource(id = R.string.verifyEmail),
                color = colorResource(id = R.color.blue),
                modifier = Modifier
                    .padding(top = 7.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,

                )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifyCodeForm(context: Context) {
    var numb by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    val context = LocalContext.current


    fun SignUp(context: Context) {
        val intent = Intent(context, SignUp::class.java)
        context.startActivity(intent)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(0.dp))


        Row {

            OutlinedTextField(
                value = numb,
                onValueChange = { numb = it },
                modifier = Modifier
                    .width(60.dp)
                    .weight(1f)
                    .padding( 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .height(55.dp),
                placeholder = {
                    Text(
                        text = "0",
                        style = TextStyle(color = Color.Gray, fontSize = 16.sp, textAlign = TextAlign.Center),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = colorResource(id = R.color.light_grey),
                    unfocusedIndicatorColor = colorResource(id = R.color.light_grey),
                    disabledIndicatorColor = colorResource(id = R.color.light_grey),
                ),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,

                )
            OutlinedTextField(
                value = numb,
                onValueChange = { numb = it },
                modifier = Modifier
                    .width(60.dp)
                    .weight(1f)
                    .padding( 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .height(55.dp),
                placeholder = {
                    Text(
                        text = "0",
                        style = TextStyle(color = Color.Gray, fontSize = 16.sp, textAlign = TextAlign.Center),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = colorResource(id = R.color.light_grey),
                    unfocusedIndicatorColor = colorResource(id = R.color.light_grey),
                    disabledIndicatorColor = colorResource(id = R.color.light_grey),
                ),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,

                )
            OutlinedTextField(
                value = numb,
                onValueChange = { numb = it },
                modifier = Modifier
                    .width(60.dp)
                    .weight(1f)
                    .padding( 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .height(55.dp),
                placeholder = {
                    Text(
                        text = "0",
                        style = TextStyle(color = Color.Gray, fontSize = 16.sp, textAlign = TextAlign.Center),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = colorResource(id = R.color.light_grey),
                    unfocusedIndicatorColor = colorResource(id = R.color.light_grey),
                    disabledIndicatorColor = colorResource(id = R.color.light_grey),
                ),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,

                )
            OutlinedTextField(
                value = numb,
                onValueChange = { numb = it },
                modifier = Modifier
                    .width(60.dp)
                    .weight(1f)
                    .padding( 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .height(55.dp),
                placeholder = {
                    Text(
                        text = "0",
                        style = TextStyle(color = Color.Gray, fontSize = 16.sp, textAlign = TextAlign.Center),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = colorResource(id = R.color.light_grey),
                    unfocusedIndicatorColor = colorResource(id = R.color.light_grey),
                    disabledIndicatorColor = colorResource(id = R.color.light_grey),
                ),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,

                )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

            ) {

            Text(
                text = "00:00",
                modifier = Modifier.padding(horizontal = 8.dp),
                color = colorResource(id = R.color.grey),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Don't receive OTP",
                modifier = Modifier.padding(horizontal = 8.dp),
                color = colorResource(id = R.color.grey),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Resend code",
                modifier = Modifier.padding(horizontal = 8.dp),
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.bodyMedium
            )

        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = {
                val intent = Intent(context, ProfileUpdate::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.blue),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text("Verify")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun VerifyCodePreview() {
    ProlearnTheme {
        VerifyCode("verify")

    }
}





