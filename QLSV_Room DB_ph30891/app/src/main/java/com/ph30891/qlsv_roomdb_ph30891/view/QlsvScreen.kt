package com.ph30891.qlsv_roomdb_ph30891.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.ph30891.qlsv_roomdb_ph30891.database.DatabaseProvider
import com.ph30891.qlsv_roomdb_ph30891.database.StudentDB
import com.ph30891.qlsv_roomdb_ph30891.model.StudentModel
import com.ph30891.qlsv_roomdb_ph30891.view.components.StudentItem
import com.ph30891.qlsv_roomdb_ph30891.view.navigator.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun QlsvScreen(navController: NavController) {
    val context = LocalContext.current
    val db = remember { DatabaseProvider.getDatabase(context) }

    var listStudent by remember { mutableStateOf(listOf<StudentModel>()) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch(Dispatchers.IO) {
            try {
                val students = db.studentDAO().getAll()
                listStudent = students
                Log.d("QlsvScreen", "Loaded students: $listStudent")
            } catch (e: Exception) {
                Log.e("QlsvScreen", "Error loading students", e)
            }
        }
    }

    var showDialog by remember { mutableStateOf(false) }
    var studentToDelete by remember { mutableStateOf<StudentModel?>(null) }
    var showDetailsDialog by remember { mutableStateOf(false) }
    var studentToShowDetails by remember { mutableStateOf<StudentModel?>(null) }

    Scaffold(
        modifier = Modifier
            .padding(top = 15.dp, bottom = 15.dp)
            .statusBarsPadding(),
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Student Manage", fontWeight = FontWeight.SemiBold, fontSize = 28.sp)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screens.ADDSCREEN.route) }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Student")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Log.d("QlsvScreen", "Displaying students: $listStudent")
            StudentColum(
                students = listStudent,
                onEditClick = { uid -> navController.navigate(Screens.UPDATESCREEN.route + "/${uid}") },
                onDeleteClick = { student ->
                    studentToDelete = student
                    showDialog = true
                },
                onDetailsClick = {student ->
                    studentToShowDetails = student
                    showDetailsDialog = true
                }
            )
        }
    }

    studentToDelete?.let { student ->
        if (showDialog) {
            DeleteConfirmationDialog(
                student = student,
                onConfirm = {
                    scope.launch(Dispatchers.IO) {
                        db.studentDAO().delete(student)
                        val updatedStudents = db.studentDAO().getAll()
                        listStudent = updatedStudents
                    }
                    showDialog = false
                    studentToDelete = null
                },
                onDismiss = {
                    showDialog = false
                    studentToDelete = null
                }
            )
        }
    }
    studentToShowDetails?.let { student ->
        if(showDetailsDialog){
            DetailsDialog(
                student = student,
                onDismiss = {
                    showDetailsDialog = false
                    studentToShowDetails = null
                }
            )
        }
    }

}

@Composable
fun StudentColum(
    students: List<StudentModel>,
    onEditClick: (id: Int) -> Unit,
    onDeleteClick: (students: StudentModel) -> Unit,
    onDetailsClick: (student: StudentModel) -> Unit
) {
    LazyColumn {
        items(students.size) { index ->
            Log.d("StudentColum", "Displaying student: ${students[index]}")
            StudentItem(
                student = students[index],
                onEditClick = { onEditClick(students[index].uid) },
                onDeleteClick = { onDeleteClick(students[index]) },
                onDetailsClick = {onDetailsClick(students[index])}
            )
        }
    }
}
@Composable
fun DeleteConfirmationDialog(
    student: StudentModel,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
){
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Delete Student") },
        text = { Text(text = "Are you sure you want to delete student ${student.hoten}?") },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text(text = "Ok")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
@Composable
fun DetailsDialog(
    student: StudentModel,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Thông tin sinh viên",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        text = {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(text = "Họ tên:", fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = student.hoten ?: "")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(text = "MSSV:", fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = student.mssv ?: "")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(text = "Điểm TB:", fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = student.diemTB?.toString() ?: "")
                }
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text(text = "Ok")
            }
        }
    )
}