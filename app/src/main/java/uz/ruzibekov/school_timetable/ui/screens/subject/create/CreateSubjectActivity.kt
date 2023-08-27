package uz.ruzibekov.school_timetable.ui.screens.subject.create

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.school_timetable.ui.screens.subject.create._content.CreateSubjectContentView
import uz.ruzibekov.school_timetable.ui.screens.subject.create.listeners.CreateSubjectListeners
import uz.ruzibekov.school_timetable.ui.theme.SchoolTimeTableTheme
import java.util.Calendar

@AndroidEntryPoint
class CreateSubjectActivity : ComponentActivity(), CreateSubjectListeners {

    private val viewModel: CreateSubjectViewModel by viewModels()
    private var startTimePickerDialog: TimePickerDialog? = null
    private var endTimePickerDialog: TimePickerDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchoolTimeTableTheme {

                CreateSubjectContentView.Default(
                    state = viewModel.state,
                    listeners = this
                )

                when {

                    viewModel.state.showStartTimePickerDialog.value -> {
                        viewModel.state.showStartTimePickerDialog.value = false
                        startTimePickerDialog?.show()
                    }

                    viewModel.state.showEndTimePickerDialog.value -> {
                        viewModel.state.showEndTimePickerDialog.value = false
                        endTimePickerDialog?.show()
                    }
                }
            }
        }

        initDialog()
    }

    private fun initDialog() {
        val startCalendar = viewModel.state.startCalendar.value

        startTimePickerDialog = TimePickerDialog(
            this,
            startTimeListener,
            startCalendar.get(Calendar.HOUR),
            startCalendar.get(Calendar.MINUTE),
            true
        )

        val endCalendar = viewModel.state.endCalendar.value

        endTimePickerDialog = TimePickerDialog(
            this,
            endTimeListener,
            endCalendar.get(Calendar.HOUR),
            endCalendar.get(Calendar.MINUTE),
            true
        )
    }

    private val startTimeListener = TimePickerDialog.OnTimeSetListener { p0, hour, minute ->

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
        }

        viewModel.state.startCalendar.value = calendar
    }

    private val endTimeListener = TimePickerDialog.OnTimeSetListener { p0, hour, minute ->

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
        }

        viewModel.state.endCalendar.value = calendar
    }

    override fun onBackStack() {
        finish()
    }

    override fun createNewSubject() {
        viewModel.createNewSubject()
        finish()
    }
}