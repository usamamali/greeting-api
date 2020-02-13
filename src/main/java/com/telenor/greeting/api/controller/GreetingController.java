package com.telenor.greeting.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

/**
 * @author usama
 */

@RestController
@Validated
public class GreetingController {

    @GetMapping(path = "/greeting", params = {"account=personal", "id"})
    public ResponseEntity<String> greetPersonalAccount(@RequestParam(name = "id") @Min(value = 1, message = "Id should be positive") int id) {
        return ResponseEntity.ok(String.format("Hi, userId %s", id));
    }
}
