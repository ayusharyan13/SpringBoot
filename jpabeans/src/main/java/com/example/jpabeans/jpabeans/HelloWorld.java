package com.example.jpabeans.jpabeans;

public class HelloWorld {
    private String message;
    private String data;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "data: " + this.data + " message: " + this.message;
    }
}

