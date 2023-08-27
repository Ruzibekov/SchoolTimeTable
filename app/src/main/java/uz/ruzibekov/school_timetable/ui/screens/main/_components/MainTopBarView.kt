package uz.ruzibekov.school_timetable.ui.screens.main._components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.ruzibekov.school_timetable.R

object MainTopBarView {

    @Composable
    fun Default(onClick: () -> Unit) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.time_table),
                fontSize = 32.sp,
                color = Color.White
            )

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(24.dp)
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "add icon"
                )
            }
        }
    }
}