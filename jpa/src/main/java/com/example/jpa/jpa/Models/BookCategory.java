package com.example.jpa.jpa.Models;

import jakarta.persistence.*;

import java.util.Iterator;
import java.util.Set;

@Entity
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "bookCategory",cascade = CascadeType.ALL)   // one category has many books: set of books
    private Set<Book> books;


    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public String getName () {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public  BookCategory(String name) {
        this.name = name;
    }







    // case : when you want to insert books
    public BookCategory(String name, Set<Book> books) {
        this.name = name;
        this.books = books;

        //  now we need to set the bookCategory for each of these books:  easy way to do this is:
        this.books.forEach(x->x.setBookCategory(this));


        /*   another way to assign bookCategory by using iterator

        Iterator it = books.iterator();
        while(it.hasNext()) {
            Book book = (Book)it.next();
            book.setBookCategory(this);
        }
*/

    }


    // default constructor:

    public BookCategory() {}

}
