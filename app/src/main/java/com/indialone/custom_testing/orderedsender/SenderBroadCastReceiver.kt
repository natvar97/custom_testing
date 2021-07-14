package com.indialone.custom_testing.orderedsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SenderBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var resultCode = resultCode
        var resultData = resultData
        val resultExtra = getResultExtras(true)

        var stringExtra = resultExtra.getString("stringExtra")

        resultCode++
        stringExtra += "->SenderBroadcast Receiver"

        val toastText =
            "SenderBroadcast Receiver\nresult code: $resultCode\nresultData: $resultData\nstring extra: $stringExtra"

        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show()

        resultData = "SenderBroadcast Receiver"
        resultExtra.putString("stringExtra", stringExtra)
        setResult(resultCode, resultData, resultExtra)
    }
}