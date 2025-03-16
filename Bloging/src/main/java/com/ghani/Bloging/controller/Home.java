package com.ghani.Bloging.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/")
    public ResponseEntity<String> homeRoute() {
        return new ResponseEntity<>("Well Come Home", HttpStatus.OK);
    }

}
