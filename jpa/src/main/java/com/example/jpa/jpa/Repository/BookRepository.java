package com.example.jpa.jpa.Repository;

import com.example.jpa.jpa.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// repository is always an interface (book repository an interface)
// JpaRepository expects Type of data and primary key::: Book is the type of data(generic type object) , Integer is the primary key

// whenever u want to inject class as a dependency: create @Bean or @component
public interface BookRepository extends JpaRepository<Book,Integer> {

    /* extra queries that we need to implement can be implemented like this in complex project:
    @Query("value = select * from book where  book.name = name")
    List<Book> findByName(String name);

     */

    /* we need to define only the custom implementations which are not implemented in jpaRepository   */

    /*     If you don't want to fetch something by the @Query Annotation:
          --> public List<Book> findByProperty(Datatype property);

              it will return all the data from the sql table with the given property name.
              given below is the example:

              // now we want to fetch all the books by given name:

              public List<Book> findByauthorName(String name);

              public List<Book> findBycost(int cost);
     */

    // 2 types of query language:  1) JPQL     2) Native Query language

    // this is native query language:
    // here parameterName should be same as sql table name like: here it is authorName but in sql it is author_name (sql no camelcase)
    @Query(value = "select * from book b where b.author_name=:my_name", nativeQuery = true)
    public List<Book> findByAuthor(String my_name);

    // this is jpql --> java persistent query language:


    // no need to define same as sql table columns as it does the mapping from java object to sql
    @Query(value = "select b from Book b where b.authorName=:authors_name")
    public List<Book> findByAuthors(String authors_name);







}
