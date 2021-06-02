package com.example.apod.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.apod.data.dao.ApodDao
import com.mindorks.framework.mvvm.data.model.Adop

@Database(entities = [Adop::class], version = 1, exportSchema = false)



abstract class AppDatabase : RoomDatabase() {

    abstract fun apodDao(): ApodDao


    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "APOD_DB")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

}