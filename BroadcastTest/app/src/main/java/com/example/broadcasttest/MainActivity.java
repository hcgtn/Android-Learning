package com.example.broadcasttest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    //    private NetworkChangeReceiver networkChangeReceiver;
    private static final String TAG = "MainActivity>>>>>>>";
    private ConnectivityManager connectivityManager;
    private ConnectivityManager.NetworkCallback networkCallback;
    private MyBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("VERSION",
                "SDK_INT = " + Build.VERSION.SDK_INT
                        + ", RELEASE = " + Build.VERSION.RELEASE
        );


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver, intentFilter);

        // 发送自定义广播 start

        // 动态注册 start API 33+ 必须带 flag），Receiver，只存在于内存中
//        receiver = new MyBroadcastReceiver(); // ✅ 赋值给成员变量
//        IntentFilter filter = new IntentFilter();
//        filter.addAction("com.example.broadcasttest.MY_BROADCAST");
//        registerReceiver(
//                receiver,
//                filter,
//                Context.RECEIVER_NOT_EXPORTED
//        );
        // 动态注册 end


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w(TAG, "onClick: button.setOnClickListener");

                // 隐式发送广播 start
//                Android 13+ 规则：
//                🔸 RECEIVER_NOT_EXPORTED
//                🔸 + 隐式广播
//                🔸 👉 必须 intent.setPackage(getPackageName())
//                Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
//                intent.setPackage(getPackageName()); // ⭐⭐⭐ 关键中的关键
//                sendBroadcast(intent);
//
                // 不能 setPackage，只能静态

                // 1.广播不限制包名（最常见）start
                // 不限制包名
                // ❌ 绝大多数被系统限制
//                Intent intent = new Intent("com.example.MY_GLOBAL_BROADCAST");
                // 广播不限制包名（最常见）end


                // 2.显示指定目标APP start （跨应用但不影响自己）
//                Intent intent = new Intent("com.example.MY_GLOBAL_BROADCAST");
//                intent.setPackage("com.example.broadcasttest2");
                // 显示指定目标APP end

                // 3.显示指定组建 start （最精确）
                // 发自己
//                Intent i1 = new Intent();
//                i1.setComponent(new ComponentName(
//                        "com.example.broadcasttest",
//                        "com.example.broadcasttest.MyBroadcastReceiver"
//                ));
//                i1.putExtra("msg", "来自 App A");
//                sendBroadcast(i1);
                // 发别人
//                Intent intent = new Intent();
//                intent.setComponent(
//                        new ComponentName(
//                                "com.example.broadcasttest2",
//                                "com.example.broadcasttest2.AnotherBroadcastReceiver"
//                        )
//                );
                // 显式指定组建 end

//                intent.putExtra("msg", "来自 App A 的广播");
//                sendBroadcast(intent);
//                Toast.makeText(MainActivity.this, "我发广播了", Toast.LENGTH_SHORT).show();
                // 隐式发送广播 end

//                显示广播 start 只能静态注册
//                Intent intent = new Intent(MainActivity.this, MyBroadcastReceiver.class);
//                sendBroadcast(intent);
//                隐式广播 end

                // 发送有序广播 start
                Intent intent = new Intent("com.example.ORDERED_TEST");
                // ⭐ Android 8+ 必须定向（否则收不到）
                intent.setPackage(getPackageName());
                intent.putExtra("msg", "原始消息");
                sendOrderedBroadcast(
                        intent,
                        null   // 不限制权限
                );

                // 跨应用
//                sendOrderedBroadcast(
//                        intent,
//                        "com.example.permission.ORDERED"
//                );
                // 发送有序广播 end

            }
        });
        // 发送自定义广播 end


        // 动态监听网络变化 start
        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@NonNull Network network) {
                runOnUiThread(() -> {
                            Toast.makeText(MainActivity.this, "network is available", Toast.LENGTH_SHORT).show();

                            Log.w(TAG, "network is available: ");
                        }


                );
            }

            @Override
            public void onLost(@NonNull Network network) {
                runOnUiThread(() -> {
                            Toast.makeText(MainActivity.this, "network is unavailable", Toast.LENGTH_SHORT).show();
                            Log.w(TAG, "network is unavailable: ");
                        }

                );
            }
        };
        connectivityManager.registerDefaultNetworkCallback(networkCallback);

        // 动态监听网络变化 end
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
//        unregisterReceiver(networkChangeReceiver);
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }

//    class NetworkChangeReceiver extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//            if (networkInfo != null && networkInfo.isAvailable()) {
//                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
//            }
////            Toast.makeText(context, "network change", Toast.LENGTH_SHORT).show();
//        }
//    }
}