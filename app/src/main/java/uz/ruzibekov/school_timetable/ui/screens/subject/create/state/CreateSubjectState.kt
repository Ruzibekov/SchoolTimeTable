package uz.ruzibekov.school_timetable.ui.screens.subject.create.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import java.util.Calendar

data class CreateSubjectState(
    val name: MutableState<String> = mutableStateOf(""),

    val showStartTimePickerDialog: MutableState<Boolean> = mutableStateOf(false),
    val startCalendar: MutableState<Calendar> = mutableStateOf(Calendar.getInstance()),

    val showEndTimePickerDialog: MutableState<Boolean> = mutableStateOf(false),
    val endCalendar: MutableState<Calendar> = mutableStateOf(getEndTimeCalendar()),
)

fun getEndTimeCalendar(): Calendar {
    val calendar = Calendar.getInstance().apply {
        val currentHour = get(Calendar.HOUR_OF_DAY)
        set(Calendar.HOUR_OF_DAY, currentHour + 1)
    }
    return calendar
}