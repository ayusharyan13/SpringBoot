package com.example.jdbc1app.jdbc_one.DAOs;


//  DAO == Data Access Object  --> A class which is needed to access info from the database
// This class Person represents the table in the database
public class Person {

    // mapping java object to table in the Person database:

    private int id;   // it will be the primary key of the table
    private String name;
    private int age;
    private String address;

    // constructor:
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(String name, int age, String address, int id) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + " name: " + this.name + " age: " + this.age + " address: " + this.address;
    }
}
