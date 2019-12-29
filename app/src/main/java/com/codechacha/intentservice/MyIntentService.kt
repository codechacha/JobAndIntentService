package com.codechacha.intentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    companion object {
        const val TAG = "MyIntentService"
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "MSG: ${intent?.getStringExtra("MSG")}")
        for (i in 1..10) {
            Thread.sleep(1000)
            Log.d(TAG, "onHandleIntent() : $i")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Job execution finished")
    }
}
