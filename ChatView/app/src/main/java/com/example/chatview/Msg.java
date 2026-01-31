package com.example.chatview;

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;
    private final String content;
    private final int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return this.content;
    }

    public int getType() {
        return this.type;
    }

}
