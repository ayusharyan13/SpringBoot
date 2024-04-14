package com.example.springmongo.demomongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Books,Integer> {

    public List<Books> findByAuthorName(String name);
}