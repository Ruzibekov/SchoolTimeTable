package uz.ruzibekov.school_timetable.ui.screens.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uz.ruzibekov.school_timetable.ui.screens.main._content.MainContentView
import uz.ruzibekov.school_timetable.ui.screens.main.listeners.MainListeners
import uz.ruzibekov.school_timetable.ui.screens.time_table.create.CreateTimeTableActivity
import uz.ruzibekov.school_timetable.ui.theme.SchoolTimeTableTheme

class MainActivity : ComponentActivity(), MainListeners {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchoolTimeTableTheme {

                MainContentView.Default(
                    listeners = this
                )
            }
        }
    }

    override fun openCreateTimeTableScreen() {
        val intent = Intent(this, CreateTimeTableActivity::class.java)
        startActivity(intent)
    }
}