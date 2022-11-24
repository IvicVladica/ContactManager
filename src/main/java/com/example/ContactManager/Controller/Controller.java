package com.example.ContactManager.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/api/contacts")
    public String hello() {
        return "Hello world!";
    }


}