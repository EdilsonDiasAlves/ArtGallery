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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.model.ArtWork
import com.example.artgallery.repository.ArtWorkRepository
import com.example.artgallery.ui.theme.ArtGalleryTheme
import com.example.artgallery.ui.theme.DarkBlue
import com.example.artgallery.ui.theme.LightBlue

class MainActivity : ComponentActivity() {

    private val artWorkRepository by lazy { ArtWorkRepository(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val artWorks = artWorkRepository.artWorks
        setContent {
            ArtGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtWorkLayout(artWorks)
                }
            }
        }
    }
}

@Composable
fun ArtWorkLayout(artWorks: List<ArtWork>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
            .padding(top = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {

        var currentIndex by rememberSaveable  { mutableStateOf(0) }
        ArtWorkIllustration(artWorks[currentIndex], modifier = Modifier.align(CenterHorizontally))
        ArtWorkDetails(artWorks[currentIndex], modifier = Modifier.align(CenterHorizontally))
        ButtonSection(
            onPreviousClick = {
                if(currentIndex > 0) currentIndex --
        },
            onNextClick = {
                if(currentIndex < artWorks.size - 1) currentIndex ++
            }
        )
    }
}

@Composable
fun ArtWorkIllustration(artWork: ArtWork, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .padding(bottom = 50.dp)
        .background(Color.Transparent)
        .shadow(elevation = 5.dp, spotColor = Color.Transparent)
        .border(1.dp, Color.LightGray)) {
        Image(
            painter = painterResource(id = artWork.imageResId),
            contentDescription = artWork.description,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(350.dp)
                .padding(start = 10.dp, top = 20.dp, end = 10.dp, bottom = 20.dp)
        )
    }
}

@Composable
fun ArtWorkDetails(artWork: ArtWork, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(LightBlue)
            .padding(10.dp)
            .width(300.dp)
    ) {
        Text(
            text = artWork.title,
            fontSize = 20.sp,
            modifier = Modifier

        )
        Text(
            text = artWork.author + " (" + artWork.year + ")",
            fontSize = 15.sp,
            modifier = Modifier
        )
    }
}

@Composable
fun ButtonSection(onPreviousClick: () -> Unit, onNextClick: () -> Unit, modifier:Modifier = Modifier) {
    Row(
        modifier = modifier.padding(top = 20.dp)
    ) {
        Button(
            onClick = onPreviousClick,
            colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
            modifier = Modifier.width(130.dp)) {
            Text(stringResource(R.string.previous_button_text))
        }
        Spacer(Modifier.weight(1f))
        Button(
            onClick = onNextClick,
            colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
            modifier = Modifier.width(130.dp)) {
            Text(stringResource(R.string.next_button_text))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        ArtWorkLayout(
            listOf(
                ArtWork(
                    title = stringResource(id = R.string.image1_title),
                    description = stringResource(id = R.string.image1_description),
                    author = stringResource(id = R.string.image1_author),
                    year = stringResource(id = R.string.image1_year),
                    imageResId = R.drawable.image1)
            )
        )
    }
}