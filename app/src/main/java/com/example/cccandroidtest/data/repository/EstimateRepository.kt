package com.example.cccandroidtest.data.repository

import com.example.cccandroidtest.data.local.model.EstimateWithPerson
import io.reactivex.Flowable

interface EstimateRepository {

    fun getNewestEstimateAsFlowable(): Flowable<EstimateWithPerson>
}