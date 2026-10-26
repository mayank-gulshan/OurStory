package com.example.ourstory.screen

import androidx.compose.ui.res.painterResource
import com.example.ourstory.R


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

data class DreamItem(
    val title: String,
    var completed: Boolean
)

@Composable
fun FutureDreamsScreen(
    onBackClick: () -> Unit = {}
) {

    var dreams by remember {
        mutableStateOf(
            listOf(
                DreamItem("Travel the world together", false),
                DreamItem("Watch the northern lights", false),
                DreamItem("Road trip ", false),
                DreamItem("NewZealand trip", false),
                DreamItem("Build our dream home", false),
                DreamItem("Grow old together", false),
                DreamItem("Shaadi ❤️", false)


            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF050505),
                        Color(0xFF140812),
                        Color(0xFF2A1022),
                        Color(0xFF5A1F3C),
                        Color(0xFF8A365D)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
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
                    text = "Future Dreams",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )


            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                items(dreams.indices.toList()) { index ->

                    val item = dreams[index]

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Checkbox(
                            checked = item.completed,
                            onCheckedChange = { checked ->

                                dreams = dreams.toMutableList().also {
                                    it[index] = item.copy(
                                        completed = checked
                                    )
                                }
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFFFF8FA3),
                                uncheckedColor = Color(0xFFFFD4E0),
                                checkmarkColor = Color.White
                            )
                        )

                        Text(
                            text = item.title,
                            color = Color.White,
                            fontSize = 17.sp
                        )
                    }
                }

                item {

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Many more to create ❤️",
                        color = Color(0xFFFFB3C1),
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(40.dp))
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun FutureDreamsScreenPreview() {
    MaterialTheme {
        FutureDreamsScreen()
    }
}