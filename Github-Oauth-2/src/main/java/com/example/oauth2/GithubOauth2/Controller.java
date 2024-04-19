package com.example.oauth2.GithubOauth2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String home() {
        return "This is unSecured path: ";
    }

    @GetMapping("/secured")
    public String secured() {
        return "This is Secured Path";
    }

}
