package com.example.roomtest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AppDatabase db = AppDatabase.getInstance(this);
        BookDao bookDao = db.bookDao();


        Button add = findViewById(R.id.add_data);
        Button delete = findViewById(R.id.delete_data);
        Button update = findViewById(R.id.update_data);
        Button query = findViewById(R.id.query_data);
        Button queryBy = findViewById(R.id.query_data_by);
        Book book1 = new Book("三体", "刘慈欣", 300, 45.0);

// ===== 增 =====
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookDao.insertBook(book1);
            }
        });

// ===== 查 =====
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = bookDao.loadAllBooks();
                for (Book book : books) {
                    Log.d("ROOM", book.getName() + " ￥" + book.getPrice());
                }
            }
        });

// ===== 查 =====
        queryBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> result = bookDao.loadBookByName("三体");
                for (Book book : result) {
                    Log.d("ROOM", book.getName() + " ￥" + book.getPrice());
                }
            }
        });

// ===== 改 =====
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book("Android", "Tom", 10, 99.9);
                book.setId(1);   // ★ 必须指定主键
                db.bookDao().updateBook(book);
            }
        });


// ===== 删 =====
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.bookDao().deleteById(3);
            }
        });
    }
}