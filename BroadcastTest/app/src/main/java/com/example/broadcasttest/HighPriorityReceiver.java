package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class HighPriorityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String msg = intent.getStringExtra("msg");
        Log.w("HIGH", "收到：" + msg);

        // 修改数据
        intent.putExtra("msg", "已被 High 修改");

        Toast.makeText(context, "HighPriorityReceiver", Toast.LENGTH_SHORT).show();

        // ❌ 如果你打开这行，后面全收不到
//         abortBroadcast();
    }
}
