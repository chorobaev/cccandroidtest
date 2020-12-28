package com.example.cccandroidtest.dagger.modules

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.cccandroidtest.data.AppDatabase
import com.example.cccandroidtest.data.local.dao.EstimateDao
import com.example.cccandroidtest.data.local.dao.PersonDao
import com.example.cccandroidtest.utils.DATABASE_NAME
import com.example.cccandroidtest.workers.SeedDatabaseWorker
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideWorkManager(app: Application): WorkManager =
        WorkManager.getInstance(app)

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application, workManager: WorkManager): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, DATABASE_NAME)
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)

                    val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                    workManager.enqueue(request)
                }
            })
            .build()

    @Provides
    fun provideEstimateDao(database: AppDatabase): EstimateDao = database.getEstimateDao()

    @Provides
    fun providePersonDao(database: AppDatabase): PersonDao = database.getPersonDao()
}