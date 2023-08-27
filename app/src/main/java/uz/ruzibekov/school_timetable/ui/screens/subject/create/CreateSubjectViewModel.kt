package uz.ruzibekov.school_timetable.ui.screens.subject.create

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.school_timetable.data.dao.SubjectDao
import uz.ruzibekov.school_timetable.data.entity.SubjectEntity
import uz.ruzibekov.school_timetable.ui.screens.subject.create.state.CreateSubjectState
import javax.inject.Inject

@HiltViewModel
class CreateSubjectViewModel @Inject constructor(
    private val dao: SubjectDao
) : ViewModel() {

    val state = CreateSubjectState()

    private val scope = CoroutineScope(Dispatchers.IO)

    fun createNewSubject() = scope.launch {

        val data = SubjectEntity(
            name = state.name.value,
            startTime = state.startCalendar.value.timeInMillis,
            endTime = state.endCalendar.value.timeInMillis
        )
        dao.insert(data)
    }

}