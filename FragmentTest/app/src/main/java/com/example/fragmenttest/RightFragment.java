package com.example.fragmenttest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RightFragment extends Fragment {
    private static final String TAG = "RightFragment";

    // 3️⃣ 创建 Fragment 的 View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.right_fragment, container, false);
    }

    public void xxx() {
        Log.d(TAG, "xxx>>>");
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    // 2️⃣ Fragment 创建
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }


    // 4️⃣ View 创建完成
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
    }


    // 6️⃣ Fragment 即将对用户可见
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    // 7️⃣ Fragment 与用户交互（前台）
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    // 8️⃣ Fragment 暂停（被遮挡）
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    // 9️⃣ Fragment 不再可见
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    // 🔟 Fragment 的 View 被销毁
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    // 1️⃣1️⃣ Fragment 被销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    // 1️⃣2️⃣ Fragment 与 Activity 解绑
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

}