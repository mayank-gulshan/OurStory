package com.example.ourstory.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.example.ourstory.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit = {}
) {

    var progress by remember {
        mutableFloatStateOf(0f)
    }

    LaunchedEffect(Unit) {

        while (progress < 1f) {
            delay(25)
            progress += 0.01f
        }

        onSplashFinished()

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(90.dp))

            Image(
                painter = painterResource(R.drawable.heart_logo),
                contentDescription = null,
                modifier = Modifier.size(220.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "M ❤️ B",
                fontSize = 62.sp,
                fontWeight = FontWeight.Light,
                color = Color(0xFFFFD7E2),
                fontFamily = FontFamily.Cursive
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Every love story",
                fontSize = 27.sp,
                color = Color.White,
                fontFamily = FontFamily.Cursive

            )

            Text(
                text = "deserves to be remembered.",
                fontSize = 27.sp,
                color = Color.White,
                fontFamily = FontFamily.Cursive
            )

            Spacer(modifier = Modifier.height(30.dp))

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .width(170.dp)
                    .height(5.dp)
                    .clip(RoundedCornerShape(50)),
                color = Color(0xFFFF8DAA),
                trackColor = Color(0xFF3A3A3A)
            )

            Spacer(modifier = Modifier.height(40.dp))

        }

    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    backgroundColor = 0xFF000000
)
@Composable
fun SplashScreenPreview() {
    MaterialTheme {
        SplashScreen()
    }
}