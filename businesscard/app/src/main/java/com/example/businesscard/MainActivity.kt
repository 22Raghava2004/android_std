package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinesscardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinesscardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { GreetingImage(
                    message = "This is my business page Raghava! my contact info is +91 8095630939!",
                    from = "From Emma"
                )
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        // Center Message
        Text(
            text = message,
            fontSize = 45.sp,
            textAlign = TextAlign.Center,
            lineHeight = 55.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
        )

        // Bottom Right Text
        Text(
            text = from,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
    }
}
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {

    val image = painterResource(R.drawable.business_themes)

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F,
            modifier = Modifier.fillMaxSize()
        )

        Greeting(
            message = message,
            from = from,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinesscardTheme {
        GreetingImage(
            message = "This is my business page Raghava! my contact info is +91 8095630939!",
            from = "From Emma")
    }
}