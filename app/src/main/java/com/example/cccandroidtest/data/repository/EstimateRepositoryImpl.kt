package com.example.cccandroidtest.data.repository

import com.example.cccandroidtest.data.local.dao.EstimateDao
import com.example.cccandroidtest.data.local.model.EstimateWithPerson
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EstimateRepositoryImpl @Inject constructor(
    private val estimateDao: EstimateDao
) : EstimateRepository {

    override fun getNewestEstimateAsFlowable(): Flowable<EstimateWithPerson> {
        return estimateDao.getNewestEstimateAsFlowable()
    }
}