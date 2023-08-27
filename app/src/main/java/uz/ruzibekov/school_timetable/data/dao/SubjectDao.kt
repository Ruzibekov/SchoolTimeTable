package uz.ruzibekov.school_timetable.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.ruzibekov.school_timetable.data.entity.SubjectEntity

@Dao
interface SubjectDao {

    @Insert
    suspend fun insert(entity: SubjectEntity)

    @Query("SELECT * FROM subjects")
    suspend fun getSubjectList(): List<SubjectEntity>
}