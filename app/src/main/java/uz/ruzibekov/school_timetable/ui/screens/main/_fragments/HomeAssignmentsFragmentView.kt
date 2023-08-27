package uz.ruzibekov.school_timetable.ui.screens.main._fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.ruzibekov.school_timetable.R
import uz.ruzibekov.school_timetable.ui.screens.main._components.ItemAssignmentView
import uz.ruzibekov.school_timetable.ui.screens.main.state.MainState

object HomeAssignmentsFragmentView {

    @Composable
    fun Default(state: MainState) {

        Column {

            if (state.assignments.isNotEmpty())
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(top = 16.dp)
                ) {

                    items(state.assignments) { entity ->

                        ItemAssignmentView.Default(entity = entity)
                    }
                }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "add icon",
                        modifier = Modifier.size(48.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        modifier = Modifier.width(300.dp),
                        text = stringResource(id = R.string.assignments_add),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}