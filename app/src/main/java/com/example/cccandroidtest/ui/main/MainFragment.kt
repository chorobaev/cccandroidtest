package com.example.cccandroidtest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.cccandroidtest.databinding.FragmentMainBinding
import com.example.cccandroidtest.utils.MyLogger
import javax.inject.Inject

class MainFragment @Inject constructor(
    viewModelFactory: ViewModelProvider.Factory
) : Fragment(), MyLogger {

    private val viewModel: MainViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }
}