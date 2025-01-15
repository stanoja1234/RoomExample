package com.example.roomexample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Insert
    suspend fun insert(person: Person)

    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun getAllPeople(): LiveData<List<Person>>

    @Delete
    suspend fun delete(person: Person)
}