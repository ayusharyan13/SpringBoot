package com.example.jpa.jpa;

import com.example.jpa.jpa.Models.Book;
import com.example.jpa.jpa.Models.BookCategory;
import com.example.jpa.jpa.Repository.BookCategoryRepository;
import com.example.jpa.jpa.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(JpaApplication.class, args);}

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCategoryRepository bookCategoryRepository;



	@Override
	public void run(String... args) throws Exception {

		//  -----------  Command Line runner --------------
		// mainly used for doing the other tasks when the application starts:
		// such as cleanup the disk when the app starts
		// whenever the app runs: it will also run the bookRepository.create() function:
		// this function executed only once
		Set<Book> books= new HashSet<>();

		Book b1 = new Book("Ruby on rails", "Ayush Aryan", 40);
		Book b2 = new Book("java Backend" , "Tejender" ,500);

		books.add(b1);
		books.add(b2);

		bookCategoryRepository.save(new BookCategory("Non- Program languages"));

		bookCategoryRepository.save(new BookCategory("programming language",books));


		/*
		System.out.println("{ " + bookRepository.findByauthorName("ayush") + "}");
		System.out.println("{" + bookRepository.findBycost(100));

		System.out.println(bookRepository.findByAuthor("ayush"));
		System.out.println(bookRepository.findByAuthors("Thakur"));

		 */

	}
}
