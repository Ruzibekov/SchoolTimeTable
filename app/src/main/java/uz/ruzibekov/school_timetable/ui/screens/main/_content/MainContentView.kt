package uz.ruzibekov.school_timetable.ui.screens.main._content

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.ruzibekov.school_timetable.ui.screens.main.BottomNavItem
import uz.ruzibekov.school_timetable.ui.screens.main._fragments.HomeAssignmentsView
import uz.ruzibekov.school_timetable.ui.screens.main._fragments.HomeTimeTableView

object MainContentView {

    @Composable
    fun Default(navController: NavHostController) {

        NavHost(
            navController = navController,
            startDestination = BottomNavItem.TimeTable.route
        ) {

            composable(BottomNavItem.TimeTable.route){
                HomeTimeTableView.Default()
            }

            composable(BottomNavItem.Assignments.route){
                HomeAssignmentsView.Default()
            }
        }
    }
}