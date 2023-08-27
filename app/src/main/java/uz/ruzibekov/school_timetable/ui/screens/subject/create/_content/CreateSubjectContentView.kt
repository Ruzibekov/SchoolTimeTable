package uz.ruzibekov.school_timetable.ui.screens.subject.create._content

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.ruzibekov.school_timetable.R
import uz.ruzibekov.school_timetable.ui.screens.subject.create._components.CreateSubjectTopBarView
import uz.ruzibekov.school_timetable.ui.screens.subject.create.listeners.CreateSubjectListeners
import uz.ruzibekov.school_timetable.ui.screens.subject.create.state.CreateSubjectState
import uz.ruzibekov.school_timetable.ui.theme.AppColor
import java.text.SimpleDateFormat
import java.util.Calendar

object CreateSubjectContentView {

    @Composable
    fun Default(state: CreateSubjectState, listeners: CreateSubjectListeners) {

        Column {

            CreateSubjectTopBarView.Default(listeners)

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = state.name.value,
                onValueChange = { state.name.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Предмет")
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            ItemTime(
                textRes = R.string.start,
                calendar = state.startCalendar.value
            ) {
                state.showStartTimePickerDialog.value = true
            }

            ItemTime(
                textRes = R.string.end,
                calendar = state.endCalendar.value
            ) {
                state.showEndTimePickerDialog.value = true
            }
        }
    }
}

@Composable
fun ItemTime(textRes: Int, calendar: Calendar, onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = stringResource(textRes),
        )

        Text(
            text = calendar.getFormattedTime(),
            modifier = Modifier
                .clickable { onClick() }
                .padding(5.dp),
            color = AppColor.Primary,
        )
    }
}

@SuppressLint("SimpleDateFormat")
private fun Calendar.getFormattedTime(): String {
    val formatter = SimpleDateFormat("HH:mm")
    return formatter.format(time)
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    val state = CreateSubjectState()

    val listeners = object : CreateSubjectListeners {
        override fun onBackStack() {}
        override fun createNewSubject() {}
    }

    CreateSubjectContentView.Default(state = state, listeners = listeners)
}