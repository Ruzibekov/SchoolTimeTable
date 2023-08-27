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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.ruzibekov.school_timetable.ui.screens.subject.create._components.CreateSubjectTopBarView

object CreateSubjectContentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default() {

        Column {

            CreateSubjectTopBarView.Default()

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Предмет")
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CreateSubjectContentView.Default()
}