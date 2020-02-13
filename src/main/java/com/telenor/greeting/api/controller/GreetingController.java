package com.telenor.greeting.api.controller;

import com.telenor.greeting.api.entity.BusinessType;
import com.telenor.greeting.api.exception.NotImplementedPathException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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

    @GetMapping(path = "/greeting", params = {"account=business", "type"})
    public ResponseEntity<String> greetBusinessAccount(@RequestParam(name = "type") @NotNull BusinessType type) {

        switch (type) {
            case big:
                return ResponseEntity.ok("Welcome, business user!");
            case small:
            default:
                throw new NotImplementedPathException("This path is not implemented yet");
        }
    }
}
