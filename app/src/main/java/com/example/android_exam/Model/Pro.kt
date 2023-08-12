package com.example.android_exam.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_exam.Dao.ProductDao
import com.example.android_exam.DataBase.RoomDB

@Database(entities = [RoomDB::class], version = 0)
abstract class Pro : RoomDatabase() {

    companion object {
        fun getInstance(context: Context): Pro {
            var db = Room.databaseBuilder(context, Pro::class.java, "product")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

            return db
        }
    }

    abstract fun pro(): ProductDao
}