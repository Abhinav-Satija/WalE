package com.example.apod.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mindorks.framework.mvvm.data.model.Adop

@Dao
interface ApodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertApodData(adop: Adop)

    @Query("select * from Adop")
    fun getApod(): Adop

    @Query("DELETE FROM Adop")
    fun deleteApod()

}