package com.example.requestumtestapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.requestumtestapp.model.Brewery

@Dao
interface BreweryDao {

    @Query("SELECT * FROM brewery")
    fun getAll(): List<Brewery>

    @Insert
    fun insert(brewery: Brewery)

    @Insert
    fun insertList(breweryList: List<Brewery>)
}