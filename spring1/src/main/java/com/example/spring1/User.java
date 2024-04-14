package com.example.spring1;

public class User {

    private String name;
    private int id;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
}
