package com.indialone.custom_testing.localbroadcastsender

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.indialone.custom_testing.R

/*

    if we want to make Local broad cast manager then only initialize it with
    LocalBroadcastManager.getInstance(this) and put the localBroadcastManager object
    before sendBroadcast() , registerBroadcast() and unRetisterBroadcast() methods

 */

class LocalBroadcastActivity : AppCompatActivity() {

    private lateinit var tvLocal: TextView
    private lateinit var button: Button
    private lateinit var receiver: LocalBroadcastReceiver
    private lateinit var localBroadcastManager: LocalBroadcastManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_broadcast)

        tvLocal = findViewById(R.id.tv_local)
        button = findViewById(R.id.btn_send_broadcast_local)
        receiver = LocalBroadcastReceiver()
        localBroadcastManager = LocalBroadcastManager.getInstance(this)

        button.setOnClickListener {
            val intent = Intent("com.indialone.CUSTOM_ACTION")
            localBroadcastManager.sendBroadcast(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter("com.indialone.CUSTOM_ACTION")
        localBroadcastManager.registerReceiver(receiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        localBroadcastManager.unregisterReceiver(receiver)
    }

}