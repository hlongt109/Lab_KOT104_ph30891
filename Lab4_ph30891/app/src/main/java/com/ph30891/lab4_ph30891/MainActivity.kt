package com.ph30891.lab4_ph30891

import android.app.Dialog
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ph30891.lab4_ph30891.ui.theme.Lab4_ph30891Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginApp()
//            Bai1()
//            Bai2()
//            Scaffold(
//                floatingActionButton = {
//                    FloatingActionButton(
//                        onClick = { }) {
//                        Icon(Icons.Filled.Add,
//                            contentDescription = "Add")
//                    }
//                }
//            ) { innerPadding ->
//                Bai3(innerPadding)
//            }

        }
    }
}
@Composable
fun LoginApp(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center,
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            LoginScreen()
        }
    }
}

@Preview
@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    if(showDialog){
        DialogComponent(
            onConfirmation = { showDialog = false }, 
            dialogTitle = "Notification", 
            dialogMessage = dialogMessage
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo"
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Username") },
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(10.dp))
        RememberMeSwitch()
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (userName.isNotBlank() && password.isNotBlank()) {
                    dialogMessage = "Login successful"
//                    Toast.makeText(
//                        context, "Login successful",
//                        Toast.LENGTH_LONG
//                    ).show()
                } else {
                    dialogMessage = "Please enter username and password"
//                    Toast.makeText(
//                        context,
//                        "Please enter username and password",
//                        Toast.LENGTH_LONG
//                    ).show()
                }
                showDialog = true
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text("Login")
        }
    }
}
@Composable
fun DialogComponent(
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogMessage: String
){
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier.padding(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
           Column(
               modifier = Modifier.padding(16.dp),
               horizontalAlignment = Alignment.Start
           ) {
               Text(text = dialogTitle, style = MaterialTheme.typography.titleLarge)
               Spacer(modifier = Modifier.height(20.dp))
               Text(text = dialogMessage, style = MaterialTheme.typography.bodyMedium)
               Spacer(modifier = Modifier.height(20.dp))
               Button(
                   onClick = onConfirmation,
                   modifier = Modifier.align(Alignment.End),
                   colors = ButtonDefaults.buttonColors(
                       containerColor = Color.DarkGray,
                       contentColor = Color.White
                   )
               ) {
                   Text(text = "Oke")   
               }
           }   
        }
    }
}
@Composable
fun RememberMeSwitch(){
    var isChecked by remember { mutableStateOf(false) }
    Row (
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Switch(
            checked = isChecked, 
            onCheckedChange = {isChecked = it}
        )
        Text(text = "Remember Me?", modifier = Modifier.padding(start = 12.dp))
    }
}

@Preview
@Composable
fun Bai2(){
    val images = listOf(R.drawable.img, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3)
    Column(

    ) {
        Icon(
            painter = painterResource(id =
            R.drawable.ic_launcher_foreground),
            contentDescription = "Logo"
        )
        HorizontalListImage(imageList = images)
        VerticalListImage(imageList = images)
    }
}

@Composable
fun HorizontalListImage(imageList: List<Int>){
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .padding(16.dp)
    ) {
        imageList.forEachIndexed {index, image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = "Image Description",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(start = if (index == 0) 0.dp else 8.dp, end = 8.dp)
            )
        }
    }
}
@Composable
fun VerticalListImage(imageList: List<Int>){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .verticalScroll(scrollState)
        .padding(16.dp)) {
        imageList.forEachIndexed { index, image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = "Image Description",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(
                        top = if (index == 0) 0.dp else 8.dp,
                        bottom = 8.dp
                    )
            )
        }
    }
}

@Composable
fun Bai3(paddingValues: PaddingValues){
    val notes = listOf("Note 1","Note 2","Note 3","Note 4","Note 5")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
            .padding(8.dp)
    ) {
        notes.forEach { note ->
            NoteCard(noteText = note)
        }
    }
}
@Composable
fun NoteCard(noteText: String){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Color.LightGray, shape = MaterialTheme.shapes.medium)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = noteText,
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
           Icon(
               imageVector = Icons.Filled.KeyboardArrowDown,
               contentDescription = "Expand Note",
               modifier = Modifier
                   .padding(16.dp)
                   .align(Alignment.CenterVertically)
           )
        }
    }
}