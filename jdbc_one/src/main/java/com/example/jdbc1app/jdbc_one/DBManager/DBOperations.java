package com.example.jdbc1app.jdbc_one.DBManager;

import com.example.jdbc1app.jdbc_one.DAOs.Person;
import com.example.jdbc1app.jdbc_one.Requests.CreateRequest;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    // if a thread t1 has open connection, then make sure that no other thread try to open connection:
    // because that will be useless thing. Noi of connection inc , then latency increase
    // So I have used volatile == Stored in ram(access for all threads at this main mem. location)
    // it is singleton pattern


    public static volatile Connection connection;


    // Connection(Java.sql) --> gets db Connection from any db with tabular format(sql)
    public static Connection getConnection() throws SQLException {
        if(connection == null) {
            // class level lock (only one thread can reside in critical section at once
            synchronized (DBOperations.class) {
                // jdbc is protocol in url
                // if you run oracle server also and mysql server also --> they would run on diff. ports
                // but they would have same hostname : so need to specify db type after jdbc

                if(connection == null) {
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/person_4","root" ,
                            "Aryan@123");
                }
            }
        }
        return connection;
    }



    // to close connection from db
    public static void closeConnection() throws SQLException {
        if(connection != null) {
            synchronized (DBOperations.class) {
                if(connection != null) {
                    connection = null;
                }
            }
        }
    }



    // to create table in the db
    public static void createTable(String name) throws SQLException {
        // this type of query are compiled by java and then sent to mysql
        getConnection();
        Statement statement = connection.createStatement();
        boolean isCreated = statement.execute("CREATE TABLE " + name + " (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), age INT, address VARCHAR(50))");


        if(isCreated) {
            System.out.println("Table " + name + " is created successfully");
        }
        else {
            System.out.println("Table " + name + " couldn't be created");
        }
        closeConnection();
    }



    // inserting a person in to db
    public static void insertPerson(@NotNull CreateRequest request) throws SQLException {
        getConnection();
        // inserting in DB with prepared statement
        // ? means dynamic initialization , null = for auto_incremented by sql(handled by sql itself)
        // preparedStatement is not compiled by java program, and it is directly sent to mysql server, then mysql checks this
        // in local cache whether this kind of statement exists or not , if exists then it will auto set the values from request,
        // this will decrease the runtime or latency
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO person VALUES (null, ?, ?, ?)");
        preparedStatement.setString(1, request.getName());
        preparedStatement.setString(2,request.getAddress());
        preparedStatement.setInt(3,request.getAge());
        int rows_affected = preparedStatement.executeUpdate();

        if(rows_affected > 0) {
            System.out.println("Successfully inserted the Record in the DB");
        } else {
            System.out.println("Unable to insert in the DB");
        }

        closeConnection();

/*  --------------   One way to insert in DB with SQL statement (how internally works)---------------------------------


        Person person = new Person(request.getName(),request.getAge(),request.getAddress());
        Statement statement = connection.createStatement();
        int rows_affected = statement.executeUpdate("INSERT INTO person VALUES ()");


 */
    }



    // getting person from ID
//    public Person getPersonById() throws SQLException {
//        getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM person where id = ";
//        Person personId = null;
//        if(resultSet == null) {
//            System.out.println("No records found");
//        } else {
//            String name = resultSet.getString(2);
//            String address = resultSet.getString(3);
//            int age = resultSet.getInt(4);
//            int id_1= resultSet.getInt(1);
//            personId = new Person(name,age,address,id_1);
//            System.out.println(personId);
//        }
//        return personId;
//    }



    public static List<Person> getPersons() throws SQLException {
        // getting person object from db
        getConnection();
        Statement statement = connection.createStatement();
        // executeQuery returns the WHOLE RESULT
        ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
        List<Person> persons = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int age = resultSet.getInt(4);
            int id = resultSet.getInt(1);

            Person person = new Person(name,age,address,id);
            persons.add(person);
            System.out.println(person);
        }
        return persons;
    }



    // deleting person from db
    public static void deletePerson(int id) throws SQLException {

    }


    // updating person object
    public static void updatePerson(Person person) {

    }


}
