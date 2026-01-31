package com.example.listviewtest;

public class Fruit {
    private final String name;
    private final int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return this.name;
    }

    public int getImageId() {
        return this.imageId;
    }
}
