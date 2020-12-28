package com.example.cccandroidtest.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.cccandroidtest.R
import com.example.cccandroidtest.utils.MyLogger
import javax.inject.Inject

class MainFragment @Inject constructor(
    viewModelFactory: ViewModelProvider.Factory
) : Fragment(R.layout.fragment_main), MyLogger {

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchNewestEstimate()

        viewModel.newestEstimate.observe(viewLifecycleOwner) {
            log(it)
        }
    }

}