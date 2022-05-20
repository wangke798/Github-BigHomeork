package com.example.Activity;

import java.util.List;

public class MessageDatabase {
    private String message_name;                //名字
    private List<String> message_detail;        //所有的消息
    private String message_time;                //最后一条消息的时间
    private String last_message;                //最后一条消息
    private int header;                         //头像

    //三个构造方法
    public MessageDatabase() {
    }

    public MessageDatabase(String message_name, String last_message, int header) {
        this.message_name = message_name;
        this.last_message = last_message;
        this.header = header;
    }

    public MessageDatabase(String message_name, String last_message, String message_time, int header) {
        this.message_name = message_name;
        this.last_message = last_message;
        this.message_time = message_time;
        this.header = header;
    }

    //get方法
    public String getLast_message() {
        return last_message;
    }

    public String getMessage_name() {
        return message_name;
    }

    public List<String> getMessage_detail() {
        return message_detail;
    }

    public String getMessage_time() {
        return message_time;
    }

    public int getHeader() {
        return header;
    }

    //set方法
    public void setLast_message(String last_message) {
        this.last_message = last_message;
    }

    public void setMessage_name(String message_name) {
        this.message_name = message_name;
    }

    public void setMessage_detail(String  last_message) {
        this.message_detail.add(last_message);
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public void setMessage_time(String message_time) {
        this.message_time = message_time;
    }
}
