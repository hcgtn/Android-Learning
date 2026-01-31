package com.example.activitylifecycletest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends BaseActivity {
    private static final String TAG = "SecondActivity>>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "taskId is: " + getTaskId());
        EdgeToEdge.enable(this);
        setContentView(R.layout.second_layout);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        Button startNormalActivity = (Button) findViewById(R.id.second_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 启动活动需要穿参数的最佳写法
     * 防止别的同事再问你或者阅读你的代码
     * 需要传递什么参数一目了然
     *
     * @param context 当前实例
     * @param data1   参数1
     * @param data2   参数2
     */
    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        Log.d(TAG, "actionStart: " + data1 + "----" + data2);
        context.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onStart();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onStart();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStart();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onStart();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onStart();
        Log.d(TAG, "onRestart: ");
    }
}