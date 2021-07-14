package com.indialone.custom_testing.localbroadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class LocalBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Local Broadcast receiver in sender is called", Toast.LENGTH_SHORT)
            .show()
    }

}