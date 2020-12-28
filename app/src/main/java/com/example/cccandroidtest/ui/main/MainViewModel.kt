package com.example.cccandroidtest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.cccandroidtest.data.local.model.EstimateWithPerson
import com.example.cccandroidtest.data.local.model.Person
import com.example.cccandroidtest.data.repository.EstimateRepository
import com.example.cccandroidtest.utils.MyLogger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val estimateRepository: EstimateRepository
) : ViewModel(), MyLogger {

    private var disposable: Disposable? = null

    private val _newestEstimate = MutableLiveData<EstimateWithPerson>()
    val newestEstimate: LiveData<EstimateWithPerson> get() = _newestEstimate

    val newestEstimateCreatedDate: LiveData<String>
        get() = _newestEstimate.map {
            it.estimate.createdDate.substringBefore(" ")
        }
    val creator: LiveData<String> get() = _newestEstimate.map { it.createdBy.fullName }
    val requester: LiveData<String> get() = _newestEstimate.map { it.requestedBy.fullName }
    val contact: LiveData<String> get() = _newestEstimate.map { it.contact.fullName }

    init {
        fetchNewestEstimate()
    }

    private fun fetchNewestEstimate() {
        disposable = estimateRepository.getNewestEstimateAsFlowable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _newestEstimate.value = it
                },
                {
                    log("Error while getting an estimate")
                }
            )
    }

    private val Person.fullName get() = "$firstName $lastName"

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }
}