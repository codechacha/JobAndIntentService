package com.codechacha.intentservice

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class MyJobIntentService : JobIntentService() {

    companion object {
        const val TAG = "MyJobIntentService"
        const val JOB_ID = 1001

    }

    fun enqueueWork(context: Context, work: Intent) {
        enqueueWork(context, MyJobIntentService::class.java, JOB_ID, work)
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Job execution started")
    }

    override fun onHandleWork(intent: Intent) {
        Log.d(TAG, "MSG: ${intent?.getStringExtra("MSG")}")
        for (i in 1..10) {
            Thread.sleep(1000)
            Log.d(TAG, "onHandleWork() : $i")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Job execution finished")
    }
}
