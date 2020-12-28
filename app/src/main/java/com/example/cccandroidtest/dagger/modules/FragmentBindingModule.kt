package com.example.cccandroidtest.dagger.modules

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.cccandroidtest.dagger.factory.InjectingFragmentFactory
import com.example.cccandroidtest.dagger.mapkey.FragmentKey
import com.example.cccandroidtest.ui.main.MainFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FragmentBindingModule {

    @Binds
    fun bindFragmentFactory(factory: InjectingFragmentFactory): FragmentFactory

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    fun bindMainFragment(fragment: MainFragment): Fragment
}