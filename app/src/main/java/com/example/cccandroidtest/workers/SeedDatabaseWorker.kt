/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.cccandroidtest.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.cccandroidtest.TestApplication
import com.example.cccandroidtest.data.local.AppDatabase
import com.example.cccandroidtest.data.local.model.EstimatePersonWrapper
import com.example.cccandroidtest.utils.DATA_FILENAME
import com.example.cccandroidtest.utils.MyLogger
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams), MyLogger {

    @Inject
    lateinit var database: AppDatabase

    @Inject
    lateinit var gson: Gson

    override suspend fun doWork(): Result {
        log("start loading")
        initDagger()
        return loadData()
    }

    private fun initDagger() {
        TestApplication.appComponent().inject(this)
    }

    private suspend fun loadData(): Result = coroutineScope {
        try {
            val inputStream = applicationContext.assets.open(DATA_FILENAME)

            JsonReader(inputStream.reader()).use { jsonReader ->
                val wrapper: EstimatePersonWrapper =
                    gson.fromJson(jsonReader, EstimatePersonWrapper::class.java)

                database.getPersonDao().insert(wrapper.person)
                database.getEstimateDao().insert(wrapper.estimate)

                Result.success()
            }
        } catch (ex: Exception) {
            log("Error seeding database", ex)
            Result.failure()
        }
    }
}