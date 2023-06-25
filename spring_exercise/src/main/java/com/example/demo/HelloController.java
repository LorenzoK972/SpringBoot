package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping ("/good-morning")
    public ResponseEntity<String> index () {
        return ResponseEntity.ok("Good morning!");
    }
}
