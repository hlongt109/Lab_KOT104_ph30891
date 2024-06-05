package com.ph30891.qlsv_roomdb_ph30891.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.room.ColumnInfo
import androidx.room.Room
import com.ph30891.qlsv_roomdb_ph30891.database.DatabaseProvider
import com.ph30891.qlsv_roomdb_ph30891.database.StudentDB
import com.ph30891.qlsv_roomdb_ph30891.model.StudentModel
import com.ph30891.qlsv_roomdb_ph30891.view.navigator.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun StudentFormScreen(uid: Int, navController: NavController){
    Log.d("TAG", "uid: "+uid)
    val context = LocalContext.current
    val db = remember {
        DatabaseProvider.getDatabase(context)
    }
    var student by remember { mutableStateOf<StudentModel?>(null) }

    var hoten by remember{ mutableStateOf( "")}
    var mssv by remember{ mutableStateOf( "")}
    var diemTB by remember{ mutableStateOf("")}
    val scope = rememberCoroutineScope()
    LaunchedEffect(uid) {
        if (uid != -1) {
            withContext(Dispatchers.IO) {
                student = db.studentDAO().getById(uid)
            }
            student?.let {
                hoten = it.hoten ?: ""
                mssv = it.mssv ?: ""
                diemTB = it.diemTB?.toString() ?: "0"
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = hoten,
            onValueChange = { hoten = it },
            label = { Text("Họ tên") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = mssv,
            onValueChange = { mssv = it },
            label = { Text("MSSV") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = diemTB,
            onValueChange = { diemTB = it },
            label = { Text("Điểm TB") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                scope.launch(Dispatchers.IO){
                    if(uid == -1){
                        db.studentDAO().insert(StudentModel(hoten = hoten, mssv = mssv,diemTB = diemTB.toFloat()))
                    }else{
                        student?.let {
                            it.hoten = hoten
                            it.mssv = mssv
                            it.diemTB = diemTB.toFloat()
                            db.studentDAO().update(it)
                        }
                    }
                    withContext(Dispatchers.Main){
                        navController.navigate(Screens.QLSVSCREEN.route)
                    }
                }
            }
        ) {
            Text(text = if (uid == -1) "Add" else "Update")
        }
    }
}