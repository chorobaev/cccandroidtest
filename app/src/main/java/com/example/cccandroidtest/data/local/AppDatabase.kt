package com.example.cccandroidtest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cccandroidtest.data.local.dao.EstimateDao
import com.example.cccandroidtest.data.local.dao.PersonDao
import com.example.cccandroidtest.data.local.model.Estimate
import com.example.cccandroidtest.data.local.model.Person

@Database(entities = [Estimate::class, Person::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getEstimateDao(): EstimateDao
    abstract fun getPersonDao(): PersonDao
}
