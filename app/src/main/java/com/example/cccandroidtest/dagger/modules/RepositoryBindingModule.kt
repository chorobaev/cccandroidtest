package com.example.cccandroidtest.dagger.modules

import com.example.cccandroidtest.data.repository.EstimateRepository
import com.example.cccandroidtest.data.repository.EstimateRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryBindingModule {


    @Binds
    fun bindEstimateRepository(repo: EstimateRepositoryImpl): EstimateRepository
}