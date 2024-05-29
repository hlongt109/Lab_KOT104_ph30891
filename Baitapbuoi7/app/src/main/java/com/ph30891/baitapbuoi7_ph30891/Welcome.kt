package com.ph30891.baitapbuoi7_ph30891

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.ph30891.baitapbuoi7_ph30891.ui.theme.Gelasio
import com.ph30891.baitapbuoi7_ph30891.ui.theme.Nunito_Sans


@Preview(showBackground = true)
@Composable
fun Welcome(){
    Box(modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(id = R.drawable.bgw),
            contentDescription = null,
            contentScale =  ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column {
                Text(
                    text = "MAKE YOUR",
                    fontSize = 28.sp,
                    fontFamily = Gelasio,
                    fontWeight = FontWeight.SemiBold,
                    color = Color("#606060".toColorInt())
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "HOME BEAUTIFUL",
                    fontSize = 35.sp,
                    color = Color("#303030".toColorInt()),
                    fontFamily = Gelasio,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = """
                    The best simple place where you
                    discover most wonderful furnitures 
                    and make your home beautiful
                """.trimIndent(),
                fontSize = 18.sp,
                lineHeight = 30.sp,
                fontFamily = Nunito_Sans,
                fontWeight = FontWeight.Medium,
                color = Color("#808080".toColorInt())
            )
            Spacer(modifier = Modifier.height(35.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(top = 100.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
                shape = RoundedCornerShape(10.dp)
                ) {
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    text = "Get Started",
                    fontSize = 16.sp,
                    fontFamily = Gelasio,
                    fontWeight = FontWeight.SemiBold,
                    color = Color("#ffffff".toColorInt()))
            }
        }
    }
}