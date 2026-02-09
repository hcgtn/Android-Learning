package com.example.roomtest;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(
        entities = {Book.class},
        version = 2    // ★ 升级到版本 2
)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract BookDao bookDao();

    // ===== 数据库升级 =====
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(
                    "ALTER TABLE Book ADD COLUMN price REAL NOT NULL DEFAULT 0"
            );
        }
    };

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "BookStore.db"
                    )
                    .addMigrations(MIGRATION_1_2)
                    .allowMainThreadQueries() // 实验用，生产禁止
                    .build();
        }
        return instance;
    }
}
