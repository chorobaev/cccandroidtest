package com.example.cccandroidtest.data.local.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    foreignKeys = [
        ForeignKey(entity = Person::class, parentColumns = ["id"], childColumns = ["createdBy"]),
        ForeignKey(entity = Person::class, parentColumns = ["id"], childColumns = ["requestedBy"]),
        ForeignKey(entity = Person::class, parentColumns = ["id"], childColumns = ["contact"])
    ],
    indices = [
        Index("createdBy"),
        Index("requestedBy"),
        Index("contact")
    ]
)
data class Estimate(
    @PrimaryKey
    @SerializedName("id") val id: String,
    @SerializedName("company") val company: String,
    @SerializedName("address") val address: String,
    @SerializedName("number") val number: Int,
    @SerializedName("revision_number") val revisionNumber: Int,
    @SerializedName("created_date") val createdDate: String,
    @SerializedName("created_by") val createdBy: String,
    @SerializedName("requested_by") val requestedBy: String,
    @SerializedName("contact") val contact: String
)