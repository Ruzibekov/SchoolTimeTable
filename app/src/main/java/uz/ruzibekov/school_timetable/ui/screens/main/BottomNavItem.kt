package uz.ruzibekov.school_timetable.ui.screens.main

import uz.ruzibekov.school_timetable.R

sealed class BottomNavItem(var title: String, var icon: Int, var route: String) {

    object TimeTable : BottomNavItem("Расписания", R.drawable.ic_time_table, "time-table")
    object Assignments : BottomNavItem("Задания", R.drawable.ic_assignments, "assignments")

}