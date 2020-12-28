package com.example.cccandroidtest.data.local.dao

import androidx.room.*
import com.example.cccandroidtest.data.local.model.EstimateWithPerson
import com.example.cccandroidtest.data.local.model.Estimate

@Dao
interface EstimateDao {

    @Transaction
    @Query("SELECT * FROM Estimate ORDER BY createdBy LIMIT 1")
    suspend fun getNewestEstimate(): EstimateWithPerson

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(estimate: Estimate)
}