package uz.ruzibekov.school_timetable.ui.screens.main._components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.ruzibekov.school_timetable.data.entity.SubjectEntity
import uz.ruzibekov.school_timetable.ui.theme.AppColor
import java.text.SimpleDateFormat
import java.util.Calendar

object ItemTimeTableView {

    @Composable
    fun Default(entity: SubjectEntity) {

        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 10.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(containerColor = AppColor.Card)
        ) {

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {

                    Text(text = entity.startTime.getFormattedTime())

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = entity.endTime.getFormattedTime())
                }

                Spacer(modifier = Modifier.width(5.dp))

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp)
                        .background(Color.Gray)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = entity.name)
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun Long.getFormattedTime(): String {
        val calendar = Calendar.getInstance().apply {
            this.timeInMillis = this@getFormattedTime
        }

        val formatter = SimpleDateFormat("HH:mm")
        return formatter.format(calendar.time)
    }
}