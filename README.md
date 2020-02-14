# Greeting API
A simple REST API to for greetings.

## Table of contents
- [ Requirements ](#requirements)
- [ Solution ](#solution)
    - [ Architecture ](#architecture)
    - [ Technologies ](#technologies)
    - [ Build & Deployment ](#build-and-deployment)
    - [ Test ](#test)
    - [ Code Analysis ](#code-analysis)
    

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

##Solution

###Architecture
Per the requirement, I have designed a Java based REST API with single endpoint GET /greeting

###Technologies
- Java 11
- SpringBoot 2.2.4
- REST Assured
- Docker
- JaCoCo
- Sonar

###Build and Deployment
**Maven**

```shell
  cd greeting-api
  mvn clean package
  mvn spring-boot:run
```

**Docker**

```shell
  cd greeting-api
  docker build -t greeting-api:latest .
  docker run -p 5000:5000 greeting-api:latest 
```

###Test

**account=personal and id=123**
```shell
  curl -X GET "localhost:5000/greeting?account=personal&id=123"
```

**account=business and type=small**
```shell
  curl -X GET "localhost:5000/greeting?account=business&type=small"
```

**account=business and type=big**
```shell
  curl -X GET "localhost:5000/greeting?account=business&type=big"
```

###Code Analysis
SonarCloud public URL: https://sonarcloud.io/dashboard?id=usamamali_greeting-api

![Code quality](https://sonarcloud.io/api/project_badges/measure?project=usamamali_greeting-api&metric=alert_status 'Code Quality')
![Code Coverage](https://sonarcloud.io/api/project_badges/measure?project=usamamali_greeting-api&metric=coverage 'Code Coverage')
![Code Coverage](https://sonarcloud.io/api/project_badges/measure?project=usamamali_greeting-api&metric=sqale_rating 'Code Coverage')
![Loc](https://sonarcloud.io/api/project_badges/measure?project=usamamali_greeting-api&metric=ncloc 'Lines of Code')
![Code duplication](https://sonarcloud.io/api/project_badges/measure?project=usamamali_greeting-api&metric=duplicated_lines_density)
![Vul](https://sonarcloud.io/api/project_badges/measure?project=usamamali_greeting-api&metric=vulnerabilities)