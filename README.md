# Greeting API
A simple REST API to for greetings.

## Table of contents
- [ Requirements ](#requirements)

## Requirements
In a basic Dockerized Springboot Maven application, develop a single REST endpoint GET /greeting which behaves in a manner that fulfills the following criteria:

1. Given the following input values account=personal and id=123
   and the allowable values for an account are personal and business
   and the allowable values for id are all positive integers
   then return "Hi, userId 123".

2. Given the following input values account=business and type=small and
   and the allowable values for an account are personal and business
   and the allowable values for type are small and big
   then return an error that the path is not yet implemented.

3. Given the following input values account=business and type=big and
   and the allowable values for an account are personal and business
   and the allowable values for type are small and big
   then return "Welcome, business user!".

We should be able to:

- build the application with Maven
- build the Docker image and run it
- make a request to localhost:5000/greeting and verify the behavior
  Please provide an archive with the source code and a list of the terminal commands to build and run the application.
