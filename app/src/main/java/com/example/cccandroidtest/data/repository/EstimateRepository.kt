package com.example.cccandroidtest.data.repository

import com.example.cccandroidtest.data.local.model.EstimateWithPerson

interface EstimateRepository {

    suspend fun getNewestEstimate(): EstimateWithPerson
}