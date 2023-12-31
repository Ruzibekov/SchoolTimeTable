package uz.ruzibekov.school_timetable.ui.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.school_timetable.data.dao.AssignmentDao
import uz.ruzibekov.school_timetable.data.dao.SubjectDao
import uz.ruzibekov.school_timetable.ui.screens.main.state.MainState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val subjectDao: SubjectDao,
    private val assignmentDao: AssignmentDao
) : ViewModel() {

    val state = MainState()

    private val scope = CoroutineScope(Dispatchers.IO)

    fun fetch() = scope.launch {
        state.timeTables.clear()
        state.timeTables.addAll(subjectDao.getList())

        state.assignments.clear()
        state.assignments.addAll(assignmentDao.getList())
    }
}