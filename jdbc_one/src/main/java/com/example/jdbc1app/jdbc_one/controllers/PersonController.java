package com.example.jdbc1app.jdbc_one.controllers;

import com.example.jdbc1app.jdbc_one.DAOs.Person;
import com.example.jdbc1app.jdbc_one.DBManager.DBOperations;
import com.example.jdbc1app.jdbc_one.Requests.CreateRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PersonController {

    @GetMapping(value = "/getPersons")
    public List<Person> getPersons() throws SQLException {
        // it will call DAO to get the person object from dbManager
        return DBOperations.getPersons();
    }

    @RequestMapping(value ="/createTable",method = RequestMethod.POST)
    public void createTable(@RequestParam(value = "name") String name) throws SQLException {
        DBOperations.createTable(name);
    }


    @RequestMapping(value = "/insertPerson",method = RequestMethod.POST)
    public void insertPerson(@RequestBody CreateRequest request) throws SQLException {
        // @Request-Body accepts pojo --> plain java object:
        DBOperations.insertPerson(request);
    }

//    @GetMapping(value = "/getById")
//    public Person getPersonBYid(@RequestBody CreateRequest request) {
//
//    }

}
