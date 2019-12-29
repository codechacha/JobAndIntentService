package com.codechacha.intentservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startIntentServiceBtn.setOnClickListener {
            val intent = Intent(this, MyIntentService::class.java)
            intent.putExtra("MSG", "Do something")
            startService(intent)
        }

        startJobIntentServiceBtn.setOnClickListener {
            val intent = Intent(this, MyJobIntentService::class.java)
            intent.putExtra("MSG", "Do something")
            startService(intent)
            MyJobIntentService().enqueueWork(this,intent)
        }
    }
}
