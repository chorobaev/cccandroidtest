package com.example.cccandroidtest.data.repository

import com.example.cccandroidtest.data.local.model.Person
import io.reactivex.Flowable

interface PersonRepository {

    fun getFirstPerson(): Flowable<Person>
}