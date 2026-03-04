package com.example.cameraalbumtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.buttonTakePhoto);
        Button selectPhotoBtn = findViewById(R.id.buttonSelectPhoto);
        // 拍照按钮
        button.setOnClickListener(v -> openCamera());
        // 相册按钮
        selectPhotoBtn.setOnClickListener(v -> openAlbum());
    }


    // ================== 相机回调 ==================
    private final ActivityResultLauncher<Intent> cameraLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK) {
                    if (imageUri != null) {
                        // 用 Glide 显示图片
                        Glide.with(this)
                                .load(imageUri)
                                .into(imageView);
                    }
                }
            });

    // ================== 相册回调 ==================
    private final ActivityResultLauncher<Intent> albumLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                    Uri uri = result.getData().getData();

                    Glide.with(this)
                            .load(uri)
                            .into(imageView);
                }
            });
    private void openCamera() {
        try {
            // 创建缓存文件
            File photoFile = File.createTempFile(
                    "output_image",
                    ".jpg",
                    getExternalCacheDir()
            );

            imageUri = FileProvider.getUriForFile(
                    this,
                    getPackageName() + ".fileprovider",
                    photoFile
            );

            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageUri);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); // 授权读取
            cameraLauncher.launch(intent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 打开相册
    private void openAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        albumLauncher.launch(intent);
    }
}