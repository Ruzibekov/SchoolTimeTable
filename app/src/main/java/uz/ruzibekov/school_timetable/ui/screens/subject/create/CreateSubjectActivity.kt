package uz.ruzibekov.school_timetable.ui.screens.subject.create

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.school_timetable.ui.screens.subject.create._content.CreateSubjectContentView
import uz.ruzibekov.school_timetable.ui.screens.subject.create.listeners.CreateSubjectListeners
import uz.ruzibekov.school_timetable.ui.theme.SchoolTimeTableTheme

@AndroidEntryPoint
class CreateSubjectActivity : ComponentActivity(), CreateSubjectListeners {

    private val viewModel: CreateSubjectViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchoolTimeTableTheme {
                CreateSubjectContentView.Default(
                    state = viewModel.state,
                    listeners = this
                )
            }
        }
    }

    override fun onBackStack() {
        finish()
    }

    override fun createNewSubject() {
        viewModel.createNewSubject()
        finish()
    }
}