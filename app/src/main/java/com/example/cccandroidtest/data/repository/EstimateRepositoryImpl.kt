package com.example.cccandroidtest.data.repository

import com.example.cccandroidtest.data.local.dao.EstimateDao
import com.example.cccandroidtest.data.local.model.EstimateWithPerson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EstimateRepositoryImpl @Inject constructor(
    private val estimateDao: EstimateDao
) : EstimateRepository {

    override suspend fun getNewestEstimate(): EstimateWithPerson {
        return estimateDao.getNewestEstimate()
    }
}