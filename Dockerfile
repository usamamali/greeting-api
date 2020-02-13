# base image
# build the app
FROM maven:3.6.3-jdk-11-slim as builder

WORKDIR /usr/app

COPY pom.xml .
RUN mvn dependency:resolve

COPY src ./src

RUN mvn package -DskipTests

RUN rm -r src

FROM openjdk:11-jre-slim

WORKDIR /usr/app

COPY --from=builder /usr/app/target/greeting-api-1.0.0.jar app.jar

VOLUME /tmp

EXPOSE 5000

# default command to run every time container started
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","app.jar"]