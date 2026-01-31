package com.example.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AnotherBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "AnotherBroadcastReceiver>>>";

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(
                context,
                "收到广播：" + msg,
                Toast.LENGTH_SHORT
        ).show();
    }
}
