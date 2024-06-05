package com.ph30891.qlsv_roomdb_ph30891.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import com.ph30891.qlsv_roomdb_ph30891.model.StudentModel

@Database(entities = arrayOf(StudentModel::class), version = 1)
abstract class StudentDB : RoomDatabase(){
    abstract fun studentDAO(): StudentDAO
}

@Dao
interface StudentDAO{
    @Query("SELECT * FROM StudentModel")
    fun getAll(): List<StudentModel>

    @Query("SELECT * FROM StudentModel WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<StudentModel>

    @Query("SELECT * FROM StudentModel WHERE uid = :userId")
    fun getById(userId: Int): StudentModel?

    @Insert
    fun insert(vararg student: StudentModel)

    @Update
    fun update(student: StudentModel)

    @Delete
    fun delete(student: StudentModel)
}