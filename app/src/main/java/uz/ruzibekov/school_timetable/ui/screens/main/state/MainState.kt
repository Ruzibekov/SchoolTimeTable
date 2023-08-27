package uz.ruzibekov.school_timetable.ui.screens.main.state

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import uz.ruzibekov.school_timetable.data.entity.AssignmentEntity
import uz.ruzibekov.school_timetable.data.entity.SubjectEntity

data class MainState(
    val timeTables: SnapshotStateList<SubjectEntity> = mutableStateListOf(),
    val assignments: SnapshotStateList<AssignmentEntity> = mutableStateListOf()
)
