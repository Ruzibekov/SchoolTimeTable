package uz.ruzibekov.school_timetable.ui.screens.main._content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uz.ruzibekov.school_timetable.ui.screens.main.BottomNavItem
import uz.ruzibekov.school_timetable.ui.screens.main._components.MainBottomView
import uz.ruzibekov.school_timetable.ui.screens.main._components.MainTopBarView
import uz.ruzibekov.school_timetable.ui.screens.main._fragments.HomeAssignmentsView
import uz.ruzibekov.school_timetable.ui.screens.main._fragments.HomeTimeTableView
import uz.ruzibekov.school_timetable.ui.screens.main.listeners.MainListeners
import uz.ruzibekov.school_timetable.ui.screens.main.state.MainState

object MainContentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(
        state: MainState,
        listeners: MainListeners
    ) {

        val navController = rememberNavController()

        val navBackStackEntry by navController.currentBackStackEntryAsState()

        Scaffold(
            topBar = {
                MainTopBarView.Default(navController, listeners)
            },
            bottomBar = {
                MainBottomView.Default(navController)
            }
        ) { paddingValues ->

            Box(
                modifier = Modifier
                    .padding(paddingValues)
            ) {

                NavHost(
                    navController = navController,
                    startDestination = BottomNavItem.TimeTable.route
                ) {

                    composable(BottomNavItem.TimeTable.route) {
                        HomeTimeTableView.Default(state)
                    }

                    composable(BottomNavItem.Assignments.route) {
                        HomeAssignmentsView.Default()
                    }
                }
            }
        }
    }
}