package com.telenor.greeting.api.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author usama
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthCheckControllerTests {

    @LocalServerPort
    String port;

    @BeforeAll
    public static void enableRestAssureLoggingForFailingTests() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    public void verify_server_is_up() {
        RestAssured.baseURI = "http://localhost:" + port;
        when()
                .get("/actuator/health")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("status", equalTo("UP"));
    }
}
