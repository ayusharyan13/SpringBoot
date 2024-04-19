package com.example.jpabeans.jpabeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // for injecting some other bin

    @Autowired
    HelloWorld helloWorld;

    @GetMapping("/func")
    public void func() {
        System.out.println(helloWorld);
    }
}


// JPa is only for sql db ; not works for nosql db