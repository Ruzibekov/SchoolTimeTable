package uz.ruzibekov.school_timetable.ui.screens.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.school_timetable.ui.screens.assignment.create.CreateAssignmentActivity
import uz.ruzibekov.school_timetable.ui.screens.main._content.MainContentView
import uz.ruzibekov.school_timetable.ui.screens.main.listeners.MainListeners
import uz.ruzibekov.school_timetable.ui.screens.subject.create.CreateSubjectActivity
import uz.ruzibekov.school_timetable.ui.theme.SchoolTimeTableTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainListeners {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchoolTimeTableTheme {
                MainContentView.Default(
                    state = viewModel.state,
                    listeners = this
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetch()
    }

    override fun openCreateTimeTableScreen() {
        val intent = Intent(this, CreateSubjectActivity::class.java)
        startActivity(intent)
    }

    override fun openCreateAssignmentScreen() {
        val intent = Intent(this, CreateAssignmentActivity::class.java)
        startActivity(intent)
    }
}