package uz.ruzibekov.school_timetable.ui.screens.subject.create.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class CreateSubjectState(
    val name: MutableState<String> = mutableStateOf("")
)
