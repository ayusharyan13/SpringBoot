package com.example.jpa.jpa.Models;

import jakarta.persistence.*;

@Entity    // then only hibernate will be able to pick it up
//@Table(name = "my_book")  // changes the table name
public class Book {

    // @id means this has been kept as primary key 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // identity type is that its value is auto-incremented by the mysql
    private int id;

//    @Column(name = "book_name")   // changes the column name
    private String name;
    private String authorName;

    @Column(name = "price")
    private int cost;


    @ManyToOne   // many books can have one category
    @JoinColumn
    private BookCategory bookCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public Book( String name, String authorName, int cost) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
    }

    public Book(String name, String authorName, int cost, int bookCategory) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
        this.bookCategory = new BookCategory();
        this.bookCategory.setId(bookCategory);
    }

    // when you are creating a parameterized constructor:- then also create a default constructor :-
    // if deafult constructor not created with parameterized then , hibernate will give error as it expects a default constructor

    public Book() {}

    @Override
    public String toString() {
        return "name: " + this.name + " author: " + this.authorName + " cost: " + this.cost;
    }


}


/* Not recommended to change column name or table name in between as two different tables or 2 diff entities will be created.

 */