package uz.ruzibekov.school_timetable.ui.screens.assignment.create._content

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
import uz.ruzibekov.school_timetable.ui.screens.assignment.create._components.CreateAssignmentTopBarView
import uz.ruzibekov.school_timetable.ui.screens.assignment.create.listeners.CreateAssignmentListeners
import uz.ruzibekov.school_timetable.ui.screens.assignment.create.state.CreateAssignmentState

object CreateAssignmentContentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(state: CreateAssignmentState, listeners: CreateAssignmentListeners) {

        Column {

            CreateAssignmentTopBarView.Default(listeners)

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = state.name.value,
                onValueChange = { state.name.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Задание")
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}