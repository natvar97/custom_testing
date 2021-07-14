package com.indialone.custom_testing

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvMesage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_send_broadcast)
        tvMesage = findViewById(R.id.tv_message)

        button.setOnClickListener {
            val intent = Intent("com.indialone.CUSTOM_ACTION")
            intent.putExtra("com.indialone.EXTRA_TEXT", "This is from the another applcation")
            sendBroadcast(intent)
        }

    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            tvMesage.text = intent?.getStringExtra("com.indialone.EXTRA_TEXT")
        }
    }

    override fun onStart() {
        super.onStart()

        val intentFilter = IntentFilter("com.indialone.CUSTOM_ACTION")
        registerReceiver(broadcastReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }

}