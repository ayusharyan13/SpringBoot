package com.example.firstSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
     @GetMapping("/hi")   // hi is the API
     public static String sayHi() {
          return "HI THIS IS AYUSH FIRST SPRING SERVER API";
     }

     @GetMapping("/search")  // this is search apisp
     public static String searchAWord(@RequestParam String q) {
         DataStore db = new DataStore();
         return db.getFromDB(q);
     }
}
