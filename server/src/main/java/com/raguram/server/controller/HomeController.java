package com.raguram.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api")
public class HomeController {

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/home")
    public ResponseEntity<String> getMessage(){
        String message = "to the home page";
        return ResponseEntity.ok(message);
    }
}
