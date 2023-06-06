package com.example.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composesample.components.GradientButton
import com.example.composesample.components.OtpTextField
import com.example.composesample.ui.theme.ComposeSampleTheme
import com.example.composesample.ui.theme.LightOrange
import com.example.composesample.ui.theme.Orange200

class OtpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize().background(Color.Black),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    TopAppBar(
                        title = { Text(text = "One time password", color = Color.White) },
                        backgroundColor = Color.Black
                    )
                    Text(text = "We have send the otp to", modifier = Modifier.padding(16.dp),color = Color.White)
                    var otpValue by remember {
                        mutableStateOf("")
                    }

                    OtpTextField(
                        otpText = otpValue,
                        onOtpTextChange = { value, otpInputFilled ->
                            otpValue = value
                        },
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(text = "Didn't receive the text? Please wait for 119 secs", modifier = Modifier.padding(16.dp),color = Color.White)
                    val gradient =
                        Brush.horizontalGradient(listOf(Orange200,LightOrange))

                    GradientButton(
                        text = "Continue",
                        gradient = gradient,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                    )
                }
            }
        }
    }
}