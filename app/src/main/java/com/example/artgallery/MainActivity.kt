package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtWorkLayout()
                }
            }
        }
    }
}

@Composable
fun ArtWorkLayout() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
            .padding(top = 100.dp)
    ) {
        Box(modifier = Modifier
            .padding(bottom = 50.dp)
            .background(Color.Transparent)
            .border(1.dp, Color.LightGray)) {
            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = stringResource(R.string.image1_description),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(300.dp)
                    .padding(30.dp)
            )
        }
        ArtWorkDetails()
        ButtonSection()
    }
}

@Composable
fun ArtWorkDetails(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color("#E6EAF5".toColorInt()))
            .padding(10.dp)
            .width(300.dp)
    ) {
        Text(
            text = stringResource(R.string.image1_title),
            fontSize = 20.sp,
            modifier = Modifier

        )
        Text(
            text = stringResource(R.string.image1_author),
            fontSize = 15.sp,
            modifier = Modifier
        )
    }
}

@Composable
fun ButtonSection(modifer:Modifier = Modifier) {
    Row(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Button(
            onClick = { /* Ação do botão */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color("#6476B8".toColorInt())),
            modifier = Modifier.width(130.dp)) {
            Text("Previous")
        }
        Spacer(Modifier.weight(1f))
        Button(
            onClick = { /* Ação do botão */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color("#6476B8".toColorInt())),
            modifier = Modifier.width(130.dp)) {
            Text("Next")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        ArtWorkLayout()
    }
}