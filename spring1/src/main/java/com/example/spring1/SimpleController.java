package com.example.spring1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class SimpleController {
    DBUser db = new DBUser();



    // RequestMapping is older method of using GetMapping :
    // consumes and produces can be used with RequestMapping only
    @RequestMapping(path = "/hi", method = RequestMethod.GET , consumes = "application/json",
      produces = "application/json")
    public String sayHi() {
        return "Hello from our server";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return db.getAllUsers();
    }

    // path parameter --> used to get the details of specific user
    // http://localhost:8080/users/{id}



    /*

    simple get user by id with no additional headers changes --

    @GetMapping("/users/{id}")
    public User getAUser(@PathVariable int id) {
        return db.getAUser(id);
    }

     now lets make some changes in header and return the modified header with modified cookies :--

      encapsulating the User class with ResponseEntity<User> , we can add more fatures such as:
     editing the header and passing the header according to our needs. , we can add cookies also:
*/

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getAUser (@PathVariable int id) {
        User user1 = db.getAUser(id);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("Server", Collections.singletonList("Code of Ayush"));
        HttpStatus status = HttpStatus.CREATED;
        ResponseEntity<User> response = new ResponseEntity<User>(user1,headers,status);
        return response;
    }

    @GetMapping("/user")
    public User getAUser(@RequestParam String q) {
        return db.getAUserByName(q);
    }


    // POST method will work in POSTMAN to send the data:
    // to use select POST METHOD  --> BODY --> RAW --> JSON and then give the response as:

//        {
//            "name": "Ayush",
//                "id": 3,
//                "age": 20
//        },
//
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)  // used for changing the status code to created
    public User createUser(@RequestBody User user) {
        return db.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable int id) {
        return db.deleteAUser(id);
    }




}
