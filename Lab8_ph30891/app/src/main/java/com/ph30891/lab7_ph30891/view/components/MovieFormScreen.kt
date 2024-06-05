package com.ph30891.lab7_ph30891.view.components

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ph30891.lab7_ph30891.model.Movie
import com.ph30891.lab7_ph30891.model.entities.toMovieFormData
import com.ph30891.lab7_ph30891.model.entities.toMovieRequest
import com.ph30891.lab7_ph30891.viewModel.MovieViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun MovieFromSreen(
    navController: NavController,
    movieViewModel: MovieViewModel,
    filmId: String?
) {
    val movie = movieViewModel.getMovieById(filmId).observeAsState(initial = null).value
    val isEditing = filmId != null

    var formData by remember(movie) {
        mutableStateOf(movie?.toMovieFormData() ?: MovieFormData())
    }
    var validationError by remember { mutableStateOf<String?>(null) }
    MovieForm(
        formData = formData,
        onSave = {
            val isValid = if (isEditing) {
                validateMovieDAtaAndEnsureCompletion(formData, movie!!)
            } else {
                isAllFieldsEntered(formData)
            }
            if(isValid){
                if (isEditing) {
                    movieViewModel.updateMovie(formData.toMovieRequest()) { success ->
                        if (success as Boolean) {
                            navController.popBackStack()
                        }
                    }
                } else {
                    movieViewModel.addFilm(formData.toMovieRequest()) { success ->
                        if (success as Boolean) {
                            navController.popBackStack()
                            formData = MovieFormData() // reset
                        }
                    }
                }
            }else{
                validationError = "Please fill out all required fields correctly."
            }

        },
        onUpdateFormData = { updatedFormData ->
            formData = updatedFormData
        },
        validationError = validationError
    )
}

@Composable
fun MovieForm(
    formData: MovieFormData,
    onSave: () -> Unit,
    onUpdateFormData: (MovieFormData) -> Unit,
    validationError: String?
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()
            .statusBarsPadding()
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = formData.title,
            onValueChange = { onUpdateFormData(formData.copy(title = it)) },
            label = { Text(text = "Film name :") },
            maxLines = 3
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = formData.duration,
                onValueChange = { onUpdateFormData(formData.copy(duration = it)) },
                label = { Text("Thời Lượng *") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.weight(2f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            DatePickerField(
                label = "Ngày Chiếu *",
                selectedDate = formData.releaseDate,
                onDateSelected = { newDate ->
                    onUpdateFormData(formData.copy(releaseDate = newDate))
                },
                modifier = Modifier.weight(3f)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = formData.genre,
            onValueChange = { onUpdateFormData(formData.copy(genre = it)) },
            label = { Text("Thể Loại *") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = formData.posterUrl,
            onValueChange = { onUpdateFormData(formData.copy(posterUrl = it)) },
            label = { Text("Liên kết ảnh minh hoạ *") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 200.dp),
            value = formData.shotDescription,
            onValueChange = { onUpdateFormData(formData.copy(shotDescription = it)) },
            label = { Text("Mô Tả *") }
        )
        Spacer(modifier = Modifier.height(12.dp))
        if (validationError != null) {
            Text(text = validationError, color = androidx.compose.ui.graphics.Color.Red)
            Spacer(modifier = Modifier.height(12.dp))
        }
        Button(onClick = {
            onSave()
        }) {
            Text(text = "Save")
        }
    }

}

@Composable
fun DatePickerField(
    label: String,
    selectedDate: String,
    onDateSelected: (String) -> Unit,
    modifier: Modifier
) {
    val contex = LocalContext.current
    var showDialog by remember {
        mutableStateOf(false)
    }
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    if (showDialog) {
        val calendar = Calendar.getInstance()
        try {
            calendar.time = dateFormat.parse(selectedDate) ?: Date()
        } catch (_: Exception) {

        }

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            contex, { _, selectedYear, selectedMonth, dayOfMonth ->
                val newCalendar = Calendar.getInstance().apply {
                    set(selectedYear, selectedMonth, dayOfMonth)
                }
                onDateSelected(dateFormat.format(newCalendar.time))
            }, year, month, day
        ).apply {
            show()
        }
        LaunchedEffect(Unit) {
            showDialog = false
        }
    }
    OutlinedTextField(
        modifier = modifier,
        value = selectedDate,
        onValueChange = {},
        readOnly = true,
        label = { Text(label) },
        trailingIcon = {
            Icon(
                Icons.Default.DateRange,
                contentDescription = "Choose Date Time",
                modifier = Modifier.clickable { showDialog = true }
            )
        }
    )
}

fun isAllFieldsEntered(formData: MovieFormData): Boolean {
    return with(formData) {
        title.isNotEmpty() && releaseDate.isNotEmpty() && genre.isNotEmpty() && duration.isNotEmpty() && shotDescription.isNotEmpty() && posterUrl.isNotEmpty()
    }
}

fun validateMovieDAtaAndEnsureCompletion(formData: MovieFormData, movie: Movie): Boolean {
    if (!isAllFieldsEntered(formData)) return false
    if (formData.title != movie.title) return true
    if (formData.releaseDate != movie.releaseDate) return true
    if (formData.genre != movie.genre) return true
    if (formData.duration != movie.duration) return true
    if (formData.shotDescription != movie.shotDescription) return true
    if (formData.posterUrl != movie.posterUrl) return true

    return false
}

data class MovieFormData(
    var id: String? = "",
    var title: String = "",
    var releaseDate: String = "",
    var genre: String = "",
    var duration: String = "",
    var shotDescription: String = "",
    var posterUrl: String = ""
)
