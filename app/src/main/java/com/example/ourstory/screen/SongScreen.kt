package com.example.ourstory.screen

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourstory.R

@Composable
fun SongsScreen(
    onBackClick: () -> Unit = {}
) {

    val context = LocalContext.current
    val isPreview = LocalInspectionMode.current

    var isPlaying by remember { mutableStateOf(false) }

    val mediaPlayer = remember {
        if (!isPreview) {
            MediaPlayer.create(context, R.raw.dandelions)
        } else {
            null
        }
    }

    LaunchedEffect(Unit) {
        mediaPlayer?.start()
        isPlaying = true
    }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Black,
                        Color(0xFF1A0F16),
                        Color(0xFF3A1F2D)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onBackClick
                ) {
                    Icon(
                        painter = painterResource(
                            R.drawable.outline_arrow_left_alt_24
                        ),
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Text(
                    text = "Our Song",
                    color = Color.White,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Card(
                modifier = Modifier.size(250.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF2D1A24)
                )
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(R.drawable.images),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )

                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Dandelions ❤️",
                color = Color.White,
                fontSize = 28.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Ruth B.",
                color = Color.LightGray,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {

                    if (isPlaying) {
                        mediaPlayer?.pause()
                    } else {
                        mediaPlayer?.start()
                    }

                    isPlaying = !isPlaying
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF8FA3)
                ),
                shape = RoundedCornerShape(50.dp)
            ) {

                Icon(
                    painter = if (isPlaying)
                        painterResource(R.drawable.baseline_pause_24)
                    else
                        painterResource(R.drawable.outline_play_arrow_24),
                    contentDescription = null,
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = if (isPlaying) "Pause" else "Play",
                    color = Color.White
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SongsScreenPreview() {
    MaterialTheme {
        SongsScreen()
    }
}