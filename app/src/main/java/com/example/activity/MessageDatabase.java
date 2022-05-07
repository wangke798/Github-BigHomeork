package com.example.activity;

public class MessageDatabase {
    private String message_name;
    private String message_detail;
    private String message_time;
    private int header;

    public MessageDatabase() {
    }

    public MessageDatabase(String message_name, String message_detail, int header) {
        this.message_name = message_name;
        this.message_detail = message_detail;
        this.header = header;
    }

    public MessageDatabase(String message_name, String message_detail, String message_time, int header) {
        this.message_name = message_name;
        this.message_detail = message_detail;
        this.message_time = message_time;
        this.header = header;
    }

    public String getMessage_name() {
        return message_name;
    }

    public void setMessage_name(String message_name) {
        this.message_name = message_name;
    }

    public String getMessage_detail() {
        return message_detail;
    }

    public void setMessage_detail(String message_detail) {
        this.message_detail = message_detail;
    }

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public String getMessage_time() {
        return message_time;
    }

    public void setMessage_time(String message_time) {
        this.message_time = message_time;
    }
}
