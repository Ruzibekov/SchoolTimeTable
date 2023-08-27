package uz.ruzibekov.school_timetable.ui.screens.assignment.create

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.school_timetable.ui.screens.assignment.create._content.CreateAssignmentContentView
import uz.ruzibekov.school_timetable.ui.screens.assignment.create.listeners.CreateAssignmentListeners
import uz.ruzibekov.school_timetable.ui.theme.SchoolTimeTableTheme

@AndroidEntryPoint
class CreateAssignmentActivity : ComponentActivity(), CreateAssignmentListeners {

    private val viewModel: CreateAssignmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SchoolTimeTableTheme {
                CreateAssignmentContentView.Default(
                    state = viewModel.state,
                    listeners = this
                )
            }
        }
    }

    override fun onBackStack() {
        finish()
    }

    override fun createNewAssignment() {
        viewModel.createNewAssignment()
        finish()
    }
}