package com.example.ourstory.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourstory.R

@Composable
fun MemoriesScreen(
    onBackClick: () -> Unit = {}
) {

    val photos = listOf(
        R.drawable._1,
        R.drawable._2,
        R.drawable._3,
        R.drawable._4,
        R.drawable._5,
        R.drawable._6,
        R.drawable._7,
        R.drawable._8,
        R.drawable._9,
        R.drawable._10,
        R.drawable._11,
        R.drawable._12,
        R.drawable._13,
        R.drawable._14,
        R.drawable._15,
        R.drawable._16,
        R.drawable._17,
        R.drawable._18,
        R.drawable._19,
        R.drawable._20,
        R.drawable._21,
        R.drawable._22,
        R.drawable._23,
        R.drawable._24,
        R.drawable._25,
        R.drawable._26,




        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {


            IconButton(
                onClick = {
                    onBackClick()
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_arrow_left_alt_24),
                    contentDescription = "Back",
                    tint = Color(0xFFFFD4E0),
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "Memories",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f)
            )


        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(photos) { imageRes ->

                Image(
                    painter = painterResource(imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.75f)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun MemoriesScreenPreview() {
    MaterialTheme {
        MemoriesScreen()
    }
}