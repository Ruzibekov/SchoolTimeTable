package uz.ruzibekov.school_timetable.ui.screens.assignment.create

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import uz.ruzibekov.school_timetable.ui.screens.assignment.create.listeners.CreateAssignmentListeners

class CreateAssignmentActivity : ComponentActivity(), CreateAssignmentListeners {

    private val viewModel: CreateAssignmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

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