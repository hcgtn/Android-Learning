package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver>>>";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.w(TAG, "onReceive: MyBroadcastReceiver>>>");
        Toast.makeText(context, "接受Received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
    }
}
