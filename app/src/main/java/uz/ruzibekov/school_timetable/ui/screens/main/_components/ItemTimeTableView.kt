package uz.ruzibekov.school_timetable.ui.screens.main._components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ruzibekov.school_timetable.data.entity.SubjectEntity
import uz.ruzibekov.school_timetable.ui.theme.AppColor

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
                    .height(50.dp)
            ) {

                Column {

                    Text(text = entity.subject)
                }
            }
        }
    }
}