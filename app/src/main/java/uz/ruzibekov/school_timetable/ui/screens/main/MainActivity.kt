package uz.ruzibekov.school_timetable.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import uz.ruzibekov.school_timetable.ui.screens.main._content.MainContentView
import uz.ruzibekov.school_timetable.ui.screens.main.listeners.MainListeners
import uz.ruzibekov.school_timetable.ui.theme.SchoolTimeTableTheme

class MainActivity : ComponentActivity(), MainListeners {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchoolTimeTableTheme {
                MainContentView.Default()
            }
        }
    }
}