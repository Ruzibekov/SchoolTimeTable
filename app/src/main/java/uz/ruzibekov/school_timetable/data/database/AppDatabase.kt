package uz.ruzibekov.school_timetable.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.ruzibekov.school_timetable.data.dao.SubjectDao
import uz.ruzibekov.school_timetable.data.entity.SubjectEntity

@Database(entities = [SubjectEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun subjectDao(): SubjectDao
}