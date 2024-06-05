package com.ph30891.qlsv_roomdb_ph30891.database

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private var INSTANCE: StudentDB? = null

    fun getDatabase(context: Context):StudentDB{
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                StudentDB::class.java,
                "student.db"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}