package com.example.cccandroidtest.dagger.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cccandroidtest.dagger.factory.InjectingViewModelFactory
import com.example.cccandroidtest.dagger.mapkey.ViewModelKey
import com.example.cccandroidtest.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelBindingModule {

    @Binds
    fun bindViewModelFactory(factory: InjectingViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}