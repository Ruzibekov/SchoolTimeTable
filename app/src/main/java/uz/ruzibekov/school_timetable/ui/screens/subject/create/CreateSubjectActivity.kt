package uz.ruzibekov.school_timetable.ui.screens.subject.create

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import uz.ruzibekov.school_timetable.ui.screens.subject.create._content.CreateSubjectContentView
import uz.ruzibekov.school_timetable.ui.screens.subject.create.listeners.CreateSubjectListeners

class CreateSubjectActivity : ComponentActivity(), CreateSubjectListeners {

    private val viewModel: CreateSubjectViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateSubjectContentView.Default()
        }
    }

    override fun onBackStack() {
        finish()
    }

    override fun createNewSubject() {
        viewModel.createNewSubject()
    }
}