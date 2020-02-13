package com.telenor.greeting.api.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author usama
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerTests {

    @LocalServerPort
    String port;

    @BeforeAll
    public static void enableRestAssureLoggingForFailingTests() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void when_account_is_personal_and_id_is_123_then_succeed_ok_and_return_message() {
        RestAssured.baseURI = "http://localhost:" + port;
        given()
                .queryParam("account", "personal")
                .queryParam("id", 123)
                .when().get("/greeting")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo("Hi, userId 123"));
    }

    @Test
    public void when_account_is_personal_and_id_is_non_positive_then_fail_badRequest_and_return_message() {
        RestAssured.baseURI = "http://localhost:" + port;
        given()
                .queryParam("account", "personal")
                .queryParam("id", -1)
                .when().get("/greeting")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("message", equalTo("Id should be positive"));
    }
}
