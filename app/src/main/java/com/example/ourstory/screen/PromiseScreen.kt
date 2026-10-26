package com.example.ourstory.screen


import androidx.compose.ui.res.painterResource
import com.example.ourstory.R


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PromiseScreen(
    onBackClick: () -> Unit = {},
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

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
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

            }

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF4E7D8)
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(
                            horizontal = 28.dp,
                            vertical = 32.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "25 June 2026",
                        color = Color.DarkGray,
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "I Promise",
                        fontSize = 38.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color(0xFF3D2C28)
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    Text(
                        text = """
        To always be honest with you,
        even when the truth is difficult.

        To communicate openly,
        and never hide things from you again.

        To respect your feelings,
        your boundaries,
        and your peace of mind.

        To respect your freedom,
        your choices,
        your decisions,
        and your individuality.

        To never take your trust for granted,
        because I now understand how precious it is.

        To listen more,
        understand better,
        and value your perspective,
        even when we disagree.

        To accept responsibility for my actions
        without making excuses or shifting blame.

        To be patient while rebuilding
        the trust I damaged,
        knowing that trust is earned through actions,
        not promises.

        And if you choose to be upset,
        distant, or need time,
        I will respect that too.

        Whatever consequences my mistake brings,
        I will accept them with sincerity,
        because I know I am responsible for the hurt I caused.

        I cannot change the past,
        but every day I will work to become
        someone who deserves your trust again.

        Forever grateful for you.
        Forever choosing you.
        Forever loving you.
        ❤️
    """.trimIndent(),
                        fontSize = 18.sp,
                        lineHeight = 30.sp,
                        color = Color(0xFF3D2C28),
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(24.dp))



                    Spacer(modifier = Modifier.height(48.dp))

                    Text(
                        text = "♡",
                        fontSize = 72.sp,
                        color = Color(0xFFE87A91)
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "I Love You So much\nAlways and Forever ❤\uFE0F",
                        fontSize = 18.sp,

                        color = Color(0xFF3D2C28)
                    )
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
fun PromiseScreenPreview() {
    MaterialTheme {
        PromiseScreen()
    }
}