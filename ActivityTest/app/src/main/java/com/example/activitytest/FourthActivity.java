package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;


public class FourthActivity extends ComponentActivity {
    private static final String TAG = "FourthActivity>>>>>>";
    final private ActivityResultLauncher<Intent> launcher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                String value = data.getStringExtra("data_return");
                                Log.d(TAG, value == null ? "null" : value);
                            }
                        }
                    }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(Fourth     Activity.this, "you clicked Button1", Toast.LENGTH_SHORT).show();
//                finish();
                // 显式 Intent
//                Intent intent = new Intent(FourthActivity.this, TwoActivity.class);
//                startActivity(intent);
//                Log.i("FourthActivity", "onClick: Intent>>>");
                // 隐式 Intent
//                Intent intent2 = new Intent("com.example.activitytest.ACTION_START");
//                intent2.addCategory("com.example.activitytest.MY_CATEGORY");
//                startActivity(intent2);
//                Log.i("FourthActivity", "onClick: 隐式 Intent2>>>");
                // 启动其他应用程序
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse    ("http://www.baidu.com"));
//                startActivity(intent);
                // 其他服务
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
//                Log.i(TAG, "onClick: >>>>跳转别的应用程序");
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                startActivity(intent);
//                Log.i("FourthActivity", "onClick: Intent>>>");
                // 传递数据 putExtra
//                Intent intent = new Intent(FourthActivity.this,ThirdActivity.class);
//                String data = "hello ThirdActivity!!!!";
//                intent.putExtra("extra_data", data);
//                startActivity(intent);
                // 向上一个活动传递数据
                Intent intent = new Intent(FourthActivity.this, ThirdActivity.class);
                launcher.launch(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_item) {
            Toast.makeText(this, "you clicked Add", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.remove_item) {
            Toast.makeText(this, "you clicked Remove", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}