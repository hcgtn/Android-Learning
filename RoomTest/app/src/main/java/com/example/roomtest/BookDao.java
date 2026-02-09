package com.example.roomtest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    // 增
    @Insert
    void insertBook(Book book);

    // 删
    @Delete
    void deleteBook(Book book);

    // 改
    @Update
    void updateBook(Book book);

    // 查（全部）
    @Query("SELECT * FROM Book")
    List<Book> loadAllBooks();

    // 查（条件）
    @Query("SELECT * FROM Book WHERE name = :bookName")
    List<Book> loadBookByName(String bookName);

    // 删除所有
    @Query("DELETE FROM Book")
    void deleteAll();

    @Query("DELETE FROM Book WHERE id = :id")
    void deleteById(int id);

    @Query("UPDATE Book SET price = :price WHERE id = :id")
    int updatePriceById(int id, double price);

}
