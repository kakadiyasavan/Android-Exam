package com.example.android_exam.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.android_exam.DataBase.RoomDB

@Dao
interface ProductDao {

    @Insert
    fun insert(RoomDB : RoomDB)

    @Query("SELECT * FROM product")
    fun getpro() : List<RoomDB>

    @Delete
    fun deletepro (pro : RoomDB)

    @Update
    fun updatepro (pro : RoomDB)
}