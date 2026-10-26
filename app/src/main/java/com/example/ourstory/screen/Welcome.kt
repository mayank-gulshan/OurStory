package com.example.ourstory.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourstory.R

@Composable
fun WelcomeScreen(
    onLetsBeginClick: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.couple_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.25f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Our Story",
                color = Color(0xFFFFD4E0),
                fontSize = 62.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "A journey of love,",
                color = Color.White,
                fontSize = 28.sp
            )

            Text(
                text = "memories and us.",
                color = Color.White,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onLetsBeginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .clip(RoundedCornerShape(50.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE56B92)
                )
            ) {
                Text(
                    text = "Let's Begin",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "♥",
                color = Color(0xFFFF8FB1),
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(
        onLetsBeginClick = {}
    )
}