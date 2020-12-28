package com.example.cccandroidtest.data.local.dao

import androidx.room.*
import com.example.cccandroidtest.data.local.model.Estimate
import com.example.cccandroidtest.data.local.model.EstimateWithPerson
import io.reactivex.Flowable

@Dao
interface EstimateDao {

    @Transaction
    @Query("SELECT * FROM Estimate ORDER BY createdBy LIMIT 1")
    fun getNewestEstimateAsFlowable(): Flowable<EstimateWithPerson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(estimate: Estimate)
}