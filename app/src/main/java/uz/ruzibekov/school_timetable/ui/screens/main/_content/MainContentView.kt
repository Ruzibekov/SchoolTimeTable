package uz.ruzibekov.school_timetable.ui.screens.main._content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.ruzibekov.school_timetable.ui.screens.main.BottomNavItem
import uz.ruzibekov.school_timetable.ui.screens.main._components.MainBottomView
import uz.ruzibekov.school_timetable.ui.screens.main._components.MainTopBarView
import uz.ruzibekov.school_timetable.ui.screens.main._fragments.HomeAssignmentsView
import uz.ruzibekov.school_timetable.ui.screens.main._fragments.HomeTimeTableView

object MainContentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default() {

        val navController = rememberNavController()

        Scaffold(
            topBar = {
                MainTopBarView.Default {
                    //todo add
                }
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
                        HomeTimeTableView.Default()
                    }

                    composable(BottomNavItem.Assignments.route) {
                        HomeAssignmentsView.Default()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MainContentView.Default()
}