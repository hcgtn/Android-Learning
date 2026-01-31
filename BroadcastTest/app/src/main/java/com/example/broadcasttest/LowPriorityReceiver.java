package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class LowPriorityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String msg = intent.getStringExtra("msg");
        Log.w("LOW", "收到：" + msg);

        Toast.makeText(context, "LowPriorityReceiver", Toast.LENGTH_SHORT).show();
    }
}
