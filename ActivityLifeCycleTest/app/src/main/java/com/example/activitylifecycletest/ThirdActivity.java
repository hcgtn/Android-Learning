package com.example.activitylifecycletest;

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

public class ThirdActivity extends BaseActivity {
    private static final String TAG = "ThirdActivity>>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.third_layout);
        Log.d(TAG, "taskId is: " + getTaskId());
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        Button startNormalActivity = (Button) findViewById(R.id.third_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
//                startActivity(intent);
                // 最佳实践-随时随地退出程序
                ActivityCollector.finishAll();
                // 杀死当前进程，确保程序完全退出
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });


    }
}