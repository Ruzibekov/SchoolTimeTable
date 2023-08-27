package uz.ruzibekov.school_timetable.ui.screens.subject.create._content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ruzibekov.school_timetable.ui.screens.subject.create._components.CreateSubjectTopBarView
import uz.ruzibekov.school_timetable.ui.screens.subject.create.listeners.CreateSubjectListeners
import uz.ruzibekov.school_timetable.ui.screens.subject.create.state.CreateSubjectState

object CreateSubjectContentView {

    @OptIn(ExperimentalMaterial3Api::class)
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
        }
    }
}