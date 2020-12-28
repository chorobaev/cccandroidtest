package com.example.cccandroidtest.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.cccandroidtest.data.local.AppDatabase
import com.example.cccandroidtest.data.local.model.EstimateWithPerson
import com.example.cccandroidtest.data.repository.EstimateRepository
import com.example.cccandroidtest.data.repository.EstimateRepositoryImpl
import io.reactivex.internal.util.NotificationLite.getValue
import org.junit.*

class MainViewModelTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var viewModel: MainViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()

        val estimateRepository: EstimateRepository =
            EstimateRepositoryImpl(appDatabase.getEstimateDao())

        viewModel = MainViewModel(estimateRepository)
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Test
    @Throws(InterruptedException::class)
    fun testDefaultValues() {
        Assert.assertFalse(getValue<EstimateWithPerson>(viewModel.newestEstimate) == null)
    }
}