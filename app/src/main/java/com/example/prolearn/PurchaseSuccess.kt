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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prolearn.ui.theme.ProlearnTheme


class PurchaseSuccess : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProlearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    PurchaseScreen()
                }
            }
        }
    }
}

@Composable
fun PurchaseScreen() {
    Scaffold(

    ) { paddingValues ->
        Purchase(Modifier.padding(paddingValues))
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Purchase(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(

    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){


            Box (modifier = Modifier.padding(top=100.dp, bottom = 60.dp)){
                PurchaseContent()
            }
        }
    }
}






@Composable
fun PurchaseContent() {
    Column(

    ) {
        Row (

            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ){
            Column (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                        .border(
                            width = 0.dp,
                            color = colorResource(id = R.color.blue),
                            shape = RoundedCornerShape(100.dp)
                        )
                        .clip(RoundedCornerShape(100.dp))
                        .background(colorResource(id = R.color.blue))
                ) {


                    Icon(
                        painter = painterResource(id = R.drawable.correct),
                        contentDescription = "",
                        tint = colorResource(id = R.color.white),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(50.dp)

                    )
                }

                Text(
                    text = "Congratulation",
                    modifier = Modifier
                        .padding(start = 14.dp, end = 6.dp, top = 30.dp),
                    color = colorResource(id = R.color.grey),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "You have successfully made payment and enrolled the course",
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                        .align(Alignment.CenterHorizontally),
                    color = colorResource(id = R.color.grey_text),
                    style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Center),


                    )
            }
        }

        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.blue),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 180.dp, start = 20.dp, end = 20.dp)
                .height(55.dp)
        ) {
            Text("View E-Receipt", fontSize = 18.sp)
        }

        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.white),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp, start = 20.dp, end = 20.dp)
                .height(55.dp)
        ) {
            Text("Go To My Courses",
                fontSize = 18.sp,
                color = colorResource(id = R.color.blue)
            )
        }

    }

}



