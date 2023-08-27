package uz.ruzibekov.school_timetable.ui.screens.assignment.create._components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import uz.ruzibekov.school_timetable.R
import uz.ruzibekov.school_timetable.ui.screens.assignment.create.listeners.CreateAssignmentListeners
import uz.ruzibekov.school_timetable.ui.theme.AppColor

object CreateAssignmentTopBarView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(listeners: CreateAssignmentListeners) {

        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.new_assignment),
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = { listeners.onBackStack() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "icon arrow back",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = AppColor.Primary),
            actions = {

                IconButton(
                    onClick = { listeners.createNewAssignment() },
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_circle_check),
                        contentDescription = "check icon",
                        tint = Color.White
                    )
                }
            }
        )
    }
}