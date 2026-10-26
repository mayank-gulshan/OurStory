package com.example.ourstory.screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourstory.R
import java.time.LocalDate
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.material3.*

import java.time.temporal.ChronoUnit

private fun getDaysTogether(): Long {
    val startDate = LocalDate.of(
        2022,
        2,
        16
    ) // Change to your relationship start date

    return ChronoUnit.DAYS.between(startDate, LocalDate.now()) + 1
}



@Composable
fun EntryScreen(
    onMemoriesClick: () -> Unit = {},
    onLettersClick: () -> Unit = {},
    onSongsClick: () -> Unit = {},
    onDreamsClick: () -> Unit = {},
    onPromiseClick: () -> Unit = {}
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {



                Text(
                    text = "Our Story",
                    color = Color(0xFFFFD4E0),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium
                )

                Icon(
                    painter = painterResource(R.drawable.heart_logo),
                    contentDescription = null,
                    tint = Color(0xFFFF8FA3),
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Every moment with you\nis my favorite memory.",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                StoryCard(
                    title = "Memories",
                    emoji = "📸",
                    modifier = Modifier.weight(1f),
                    onClick = onMemoriesClick
                )


            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                StoryCard(
                    title = "Letter",
                    emoji = "💌",
                    modifier = Modifier.weight(1f),
                    onClick = onLettersClick
                )

                StoryCard(
                    title = "Our Songs",
                    emoji = "🎵",
                    modifier = Modifier.weight(1f),
                    onClick = onSongsClick
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                StoryCard(
                    title = "Future Dreams",
                    emoji = "💗",
                    modifier = Modifier.weight(1f),
                    onClick = onDreamsClick
                )

                StoryCard(
                    title = "My Promise",
                    emoji = "❤️",
                    modifier = Modifier.weight(1f),
                    onClick = onPromiseClick
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            DaysTogetherCard()

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun StoryCard(
    title: String,
    emoji: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .height(120.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF111111)
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            1.dp,
            Color(0xFF6F4B57)
        )
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = emoji,
                fontSize = 32.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = title,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun EntryScreenPreview() {
    MaterialTheme {
        EntryScreen()
    }
}
@Composable
fun DaysTogetherCard(
    modifier: Modifier = Modifier
) {

    val daysTogether = getDaysTogether()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF4A2334)
        ),
        border = BorderStroke(
            1.dp,
            Color(0xFFC57A94)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = "Days Together",
                    color = Color(0xFFFFD4E0),
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "$daysTogether Days",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Icon(
                painter = painterResource(R.drawable.heart_logo),
                contentDescription = "Heart",
                tint = Color(0xFFFF8FA3),
                modifier = Modifier.size(42.dp)
            )
        }
    }
}

