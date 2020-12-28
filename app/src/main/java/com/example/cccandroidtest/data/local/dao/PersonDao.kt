package com.example.cccandroidtest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cccandroidtest.data.local.model.Person
import io.reactivex.Flowable

@Dao
interface PersonDao {

    @Query("SELECT * FROM Person LIMIT 1")
    fun getFirstPerson(): Flowable<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: Person)
}