package com.example.cccandroidtest.dagger

import android.app.Application
import com.example.cccandroidtest.MainActivity
import com.example.cccandroidtest.dagger.modules.AppModule
import com.example.cccandroidtest.dagger.modules.FragmentBindingModule
import com.example.cccandroidtest.dagger.modules.RepositoryBindingModule
import com.example.cccandroidtest.dagger.modules.ViewModelBindingModule
import com.example.cccandroidtest.workers.SeedDatabaseWorker
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        FragmentBindingModule::class,
        ViewModelBindingModule::class,
        RepositoryBindingModule::class
    ]
)
interface AppComponent {

    fun inject(target: SeedDatabaseWorker)
    fun inject(target: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bind(app: Application): Builder
        fun build(): AppComponent
    }
}