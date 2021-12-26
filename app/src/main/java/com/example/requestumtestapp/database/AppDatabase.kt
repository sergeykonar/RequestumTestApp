package com.example.requestumtestapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.requestumtestapp.model.Brewery

@Database(entities = [Brewery::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun breweryDao(): BreweryDao
}