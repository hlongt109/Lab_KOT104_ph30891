package com.ph30891.qlsv_roomdb_ph30891.view.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ph30891.qlsv_roomdb_ph30891.model.StudentModel

@Composable
fun StudentItem(
    student: StudentModel,
    onEditClick: (id: Int) -> Unit,
    onDeleteClick: (student: StudentModel) -> Unit,
    onDetailsClick: (student: StudentModel) -> Unit
) {
    Log.d("StudentItem", "Displaying student item: $student")
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .padding(bottom = 7.dp, start = 7.dp, end = 7.dp)
            .fillMaxWidth()
            .clickable { onDetailsClick(student) }
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment =Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = student.hoten ?: "",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Justify
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = student.mssv ?: "",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Justify
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = student.diemTB.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { onEditClick(student.uid) },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit", tint = MaterialTheme.colorScheme.primary)
                }
                IconButton(
                    onClick = { onDeleteClick(student) },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(Icons.Outlined.Delete, contentDescription = "Delete", tint = MaterialTheme.colorScheme.error)
                }
            }
        }
    }
}
