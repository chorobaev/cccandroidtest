package com.example.cccandroidtest.dagger.modules

import com.example.cccandroidtest.data.repository.EstimateRepository
import com.example.cccandroidtest.data.repository.EstimateRepositoryImpl
import com.example.cccandroidtest.data.repository.PersonRepository
import com.example.cccandroidtest.data.repository.PersonRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryBindingModule {

    @Binds
    fun bindPersonRepository(repo: PersonRepositoryImpl): PersonRepository

    @Binds
    fun bindEstimateRepository(repo: EstimateRepositoryImpl): EstimateRepository
}