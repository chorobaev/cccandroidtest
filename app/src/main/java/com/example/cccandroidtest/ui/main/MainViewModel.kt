package com.example.cccandroidtest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cccandroidtest.data.local.model.EstimateWithPerson
import com.example.cccandroidtest.data.repository.EstimateRepository
import com.example.cccandroidtest.utils.MyLogger
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val estimateRepository: EstimateRepository
) : ViewModel(), MyLogger {

    private val _newestEstimate = MutableLiveData<EstimateWithPerson>()
    val newestEstimate: LiveData<EstimateWithPerson> get() = _newestEstimate

    fun fetchNewestEstimate() {
        viewModelScope.launch {
            _newestEstimate.value = estimateRepository.getNewestEstimate()
        }
    }
}