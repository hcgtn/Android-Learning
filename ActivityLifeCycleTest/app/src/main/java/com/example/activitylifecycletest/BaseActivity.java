package com.example.activitylifecycletest;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;

public class BaseActivity extends ComponentActivity {
    private static final String TAG = "BaseActivity>>>";

    @Override
    protected void onCreate(Bundle saveInstanceSate) {
        super.onCreate(saveInstanceSate);
        ActivityCollector.addActivity(this);
        Log.d(TAG, getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
