package com.example.cccandroidtest.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class EstimateWithPerson(
    @Embedded
    val estimate: Estimate,
    @Relation(
        parentColumn = "createdBy",
        entityColumn = "id"
    )
    val createdBy: Person,
    @Relation(
        parentColumn = "requestedBy",
        entityColumn = "id"
    )
    val requestedBy: Person,
    @Relation(
        parentColumn = "contact",
        entityColumn = "id"
    )
    val contact: Person
)