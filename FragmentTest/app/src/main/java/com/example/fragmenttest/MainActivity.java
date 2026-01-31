package com.example.fragmenttest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LeftFragment.OnButtonClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(this);
//        replaceFragment(new RightFragment());
        if (savedInstanceState == null) {
            // 动态添加Fragments
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.left_fragment, new LeftFragment());
            transaction.replace(R.id.right_fragment, new RightFragment());
            transaction.commit();
        }
    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.button) {
//            replaceFragment(new AnotherRightFragment());
//        }
    }

    public void replaceFragment(Fragment fragment) {
//        // 动态添加Fragments
//        FragmentManager fm = getSupportFragmentManager();
//
//        FragmentTransaction transaction = fm.beginTransaction();
////        transaction.replace(R.id.left_fragment, new LeftFragment());
//        transaction.replace(R.id.right_fragment, fragment);
//        // 将一个事物添加到返回栈中去
//        transaction.addToBackStack(null);
//        transaction.commit();
//        // 注意，这里点击一次就变成了 anotherRightFragment了，不能再转了
//        RightFragment rightFragment = (RightFragment) fm.findFragmentById(R.id.right_fragment);
//        assert rightFragment != null;
//        rightFragment.xxx();
    }

    public void onLeftButtonClick() {
        replaceFragment(new AnotherRightFragment());
    }
}