package uz.ruzibekov.school_timetable.ui.screens.assignment.create.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class CreateAssignmentState(
    val name: MutableState<String> = mutableStateOf("")
)
