package com.ph30891.baitapbuoi7_ph30891

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.ph30891.baitapbuoi7_ph30891.ui.theme.Merriweather
import com.ph30891.baitapbuoi7_ph30891.ui.theme.Nunito_Sans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val passwordVisible = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp)
            .statusBarsPadding(),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(
                    color = Color("#BDBDBD".toColorInt()),
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Divider(
                    color = Color("#BDBDBD".toColorInt()),
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .padding(end = 10.dp)
                )
            }
            //
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp, start = 20.dp, end = 20.dp)
            ) {
                Text(
                    text = "Hello !",
                    color = Color("#909090".toColorInt()),
                    fontSize = 30.sp,
                    fontFamily = Merriweather,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "WELCOME BACK",
                    color = Color("#303030".toColorInt()),
                    fontSize = 30.sp,
                    fontFamily = Merriweather,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }
            //
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(3.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp, bottom = 10.dp),

            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 40.dp, start = 17.dp, end = 17.dp, bottom = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column {
                        Text(
                            text = "Email",
                            fontSize = 16.sp,
                            color = Color("#909090".toColorInt()),
                            fontFamily = Nunito_Sans,
                            fontWeight = FontWeight.Medium
                        )
                        TextField(
                            value = emailState.value,
                            onValueChange = { emailState.value = it },
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color("#fe724c".toColorInt()),
                                unfocusedBorderColor = Color.Black
                            ),
                            textStyle = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = Nunito_Sans,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(45.dp))
                    Column {
                        Text(
                            text = "Password",
                            fontSize = 16.sp, color =
                            Color("#909090".toColorInt()),
                            fontFamily = Nunito_Sans,
                            fontWeight = FontWeight.Medium
                        )
                        TextField(
                            value = passwordState.value,
                            onValueChange = { passwordState.value = it },
                            visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                val img = if (passwordVisible.value) Icons.Filled.Visibility
                                else Icons.Filled.VisibilityOff
                                IconButton(onClick = {
                                    passwordVisible.value =! passwordVisible.value
                                }) {
                                    Icon(imageVector = img, contentDescription = "")
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color("#fe724c".toColorInt()),
                                unfocusedBorderColor = Color.Black
                            ),
                            textStyle = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = Nunito_Sans,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    TextButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Forgot Password",
                            color = Color("#303030".toColorInt()),
                            fontSize = 20.sp,
                            fontFamily = Nunito_Sans,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text(
                            text = "Log In",
                            modifier = Modifier.padding(vertical = 5.dp),
                            fontSize = 24.sp,
                            fontFamily = Nunito_Sans,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color("#ffffff".toColorInt())),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text(
                            text = "SIGN UP",
                            modifier = Modifier.padding(vertical = 5.dp),
                            fontSize = 24.sp,
                            fontFamily = Nunito_Sans,
                            fontWeight = FontWeight.SemiBold,
                            color = Color("#303030".toColorInt())
                        )
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen()
}