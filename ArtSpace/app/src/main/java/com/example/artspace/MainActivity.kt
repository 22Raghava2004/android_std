package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.runtime.*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {

    var currentArtwork by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ArtworkImage(currentArtwork)

        Spacer(modifier = Modifier.height(20.dp))

        ArtworkDescription(currentArtwork)

        Spacer(modifier = Modifier.height(20.dp))

        ControllerButtons(
            onNext = {
                if (currentArtwork < 2) {
                    currentArtwork++
                }
            },
            onPrevious = {
                if (currentArtwork > 0) {
                    currentArtwork--
                }
            }
        )
    }
}
@Composable
fun ArtworkImage(currentArtwork: Int) {

    val image = when (currentArtwork) {
        0 -> R.drawable.art1
        1 -> R.drawable.art2
        else -> R.drawable.art3
    }

    Image(
        painter = painterResource(image),
        contentDescription = "Artwork",
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentScale = ContentScale.Crop
    )
}
@Composable
fun ArtworkDescription(currentArtwork: Int) {

    val title = when (currentArtwork) {
        0 -> "Starry Night"
        1 -> "Mona Lisa"
        else -> "The Scream"
    }

    val artist = when (currentArtwork) {
        0 -> "Vincent van Gogh (1889)"
        1 -> "Leonardo da Vinci (1503)"
        else -> "Edvard Munch (1893)"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = artist,
            fontSize = 16.sp
        )
    }
}
@Composable
fun ControllerButtons(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Button(onClick = onPrevious) {
            Text("Previous")
        }

        Button(onClick = onNext) {
            Text("Next")
        }
    }
}