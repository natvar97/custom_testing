package com.indialone.custom_testing

import android.content.*
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/*
    Explicit broadcast included

 */

class MainActivity : AppCompatActivity() {

    private lateinit var tvMesage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_send_broadcast)
        tvMesage = findViewById(R.id.tv_message)

        button.setOnClickListener {
//            val intent = Intent(this, CustomBroadCastReceiver::class.java)
            val intent = Intent("com.indialone.CUSTOM_ACTION")

            val packageManager = getPackageManager()
            val infos = packageManager.queryBroadcastReceivers(intent, 0)

            for (info in infos) {
                val cn = ComponentName(info.activityInfo.packageName, info.activityInfo.name)
                intent.component = cn
                sendBroadcast(intent)
            }

//            intent.setPackage("com.indialone.broadcastreceiverdemo1")
//            sendBroadcast(intent)
        }

    }
}
/*
    * for custom broad cast use below code here

    button.setOnClickListener {
        val intent = Intent("com.indialone.CUSTOM_ACTION")
        intent.putExtra("com.indialone.EXTRA_TEXT", "This is from the another applcation")
        sendBroadcast(intent)
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
*/
