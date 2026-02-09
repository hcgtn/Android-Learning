package com.example.roomtest;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Book {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private final String name;
    private final String author;
    private final int pages;

    // ===== 新增字段（数据库升级用）=====
    private double price;

    public Book(String name, String author, int pages, double price) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    @Ignore
    public Book(String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    // getter & setter（Room 必须）
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
