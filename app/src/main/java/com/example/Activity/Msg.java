package com.example.Activity;

public class Msg {
    public static final int MSG_RECEIVE = 0;
    public static final int MSG_SEND = 1;

    private int type;
    private String content;
    private int left_header;
    private int right_header;

    public Msg(String content, int type, Integer left_header, Integer right_header) {
        this.content = content;
        this.type = type;
        this.left_header = left_header;
        this.right_header = right_header;
    }

    public String getMessage() {
        return content;
    }
    public int getType() {
        return type;
    }

    public int getLeft_header(){
        return left_header;
    }
    public int getRight_header(){
        return right_header;
    }

}
