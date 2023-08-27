package uz.ruzibekov.school_timetable.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import uz.ruzibekov.school_timetable.ui.screens.main._components.MainBottomView
import uz.ruzibekov.school_timetable.ui.screens.main._components.MainTopBarView
import uz.ruzibekov.school_timetable.ui.screens.main._content.MainContentView
import uz.ruzibekov.school_timetable.ui.screens.main.listeners.MainListeners
import uz.ruzibekov.school_timetable.ui.theme.SchoolTimeTableTheme

class MainActivity : ComponentActivity(), MainListeners {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SchoolTimeTableTheme {

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

                        MainContentView.Default(navController = navController)
                    }
                }
            }
        }
    }
}