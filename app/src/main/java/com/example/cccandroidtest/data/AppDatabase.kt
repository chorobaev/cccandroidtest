package com.example.cccandroidtest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cccandroidtest.data.local.dao.EstimateDao
import com.example.cccandroidtest.data.local.dao.PersonDao
import com.example.cccandroidtest.data.local.model.Estimate
import com.example.cccandroidtest.data.local.model.Person

@Database(
    entities = [Estimate::class, Person::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getEstimateDao(): EstimateDao
    abstract fun getPersonDao(): PersonDao
}
