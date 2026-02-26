package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionPredictor;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button sendNotice = findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(
                        new String[]{android.Manifest.permission.POST_NOTIFICATIONS},
                        100
                );
            }
        }

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_notice) {
            Intent intent = new Intent(this, NotificationActivity.class);
//            PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

            PendingIntent pendingIntent =
                    PendingIntent.getActivity(
                            this,
                            0,
                            intent,
                            PendingIntent.FLAG_IMMUTABLE
                    );

            Log.d("test", "clicked");
            String channelId = "default_channel_id221232sa2d";
            NotificationManagerCompat notificationManager =
                    NotificationManagerCompat.from(this);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                /*
                 String channelName = "默认通知";
                 //                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                 int importance = NotificationManager.IMPORTANCE_HIGH; // 重要！，importance 必须 >= HIGH 才容易有声音

                 NotificationChannel channel =
                 new NotificationChannel(channelId, channelName, importance);

                 // 使用系统默认铃声
                 Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                 AudioAttributes audioAttributes = new AudioAttributes.Builder()
                 .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                 .build();

                 channel.setSound(defaultSoundUri, audioAttributes);

                 // 8.在 Android 10+（尤其 12+、14）系统对 /system 路径的访问限制非常严格：
                 //                channel.setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Lollipop.ogg")), audioAttributes);

                 notificationManager.createNotificationChannel(channel);
                 **/

                int importance = NotificationManager.IMPORTANCE_HIGH;

                NotificationChannel channel =
                        new NotificationChannel(channelId, "默认通知", importance);

//                // 开启声音
//                Uri defaultSoundUri =
//                        RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//
//                AudioAttributes audioAttributes = new AudioAttributes.Builder()
//                        .setUsage(AudioAttributes.USAGE_NOTIFICATION)
//                        .build();
//
//                channel.setSound(defaultSoundUri, audioAttributes);
//
//                // 开启震动
//                channel.enableVibration(true);
//
//                // 自定义震动节奏（单位：毫秒）
//                long[] pattern = {0, 300, 200, 300};
//                channel.setVibrationPattern(pattern);
//
//                // LED 灯
//                channel.enableLights(true);
//                channel.setLightColor(Color.RED);

                notificationManager.createNotificationChannel(channel);


            }
//            Notification notification = new NotificationCompat.Builder(this, channelId)
//                    .setContentTitle("this is content title")
//                    .setContentText("this is Content text")
//                    .setWhen(System.currentTimeMillis())
//                    .setSmallIcon(R.mipmap.ic_launcher)
//                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
//                    .setContentIntent(pendingIntent)
//                    .setAutoCancel(true)
//                    .build();
//                    .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Lollipop.ogg")))

            // 默认效果
            Notification notification = new NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Android 开发通知")
                    .setContentText("点击查看完整内容")
//                    .setStyle(new NotificationCompat.BigTextStyle()
//                            .bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android.")
//                            .setBigContentTitle("Android 开发通知")
//                    )
                    .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.big_image)))
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build();
            notificationManager.notify(1, notification);
        }
    }
}