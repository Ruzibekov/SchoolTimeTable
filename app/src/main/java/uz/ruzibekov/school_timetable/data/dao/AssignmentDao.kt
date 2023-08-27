package uz.ruzibekov.school_timetable.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.ruzibekov.school_timetable.data.entity.AssignmentEntity

@Dao
interface AssignmentDao {

    @Insert
    fun insert(entity: AssignmentEntity)

    @Query("SELECT * FROM assignments")
    fun getList(): List<AssignmentEntity>
}