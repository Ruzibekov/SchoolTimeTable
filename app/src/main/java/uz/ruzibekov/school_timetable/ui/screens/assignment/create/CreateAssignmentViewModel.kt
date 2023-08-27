package uz.ruzibekov.school_timetable.ui.screens.assignment.create

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.school_timetable.data.dao.AssignmentDao
import uz.ruzibekov.school_timetable.data.entity.AssignmentEntity
import uz.ruzibekov.school_timetable.ui.screens.assignment.create.state.CreateAssignmentState
import javax.inject.Inject

@HiltViewModel
class CreateAssignmentViewModel @Inject constructor(
    private val dao: AssignmentDao
) : ViewModel() {

    val state = CreateAssignmentState()

    private val scope = CoroutineScope(Dispatchers.IO)

    fun createNewAssignment() = scope.launch {

        val entity = AssignmentEntity(
            name = state.name.value
        )

        dao.insert(entity)
    }


}