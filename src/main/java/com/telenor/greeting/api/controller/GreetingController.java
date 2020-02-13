package com.telenor.greeting.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author usama
 */

@RestController
public class GreetingController {

    @GetMapping(path = "/greeting", params = {"account=personal", "id"})
    public ResponseEntity<String> greetPersonalAccount(@RequestParam(name = "id") int id) {
        return ResponseEntity.ok(String.format("Hi, userId %s", id));
    }
}
