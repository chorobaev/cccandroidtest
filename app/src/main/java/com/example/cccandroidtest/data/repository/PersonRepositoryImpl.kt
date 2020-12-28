package com.example.cccandroidtest.data.repository

import com.example.cccandroidtest.data.local.dao.PersonDao
import com.example.cccandroidtest.data.local.model.Person
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PersonRepositoryImpl @Inject constructor(
    private val personDao: PersonDao
) : PersonRepository {

    override fun getFirstPerson(): Flowable<Person> {
        return personDao.getFirstPerson()
    }

}