FROM openjdk:8-jdk-alpine

LABEL maintainer = Abhilash

VOLUME /tmp

EXPOSE 9000

ARG JAR_FILE=target/rest-app-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} rest-app.jar

ENTRYPOINT ["java", "-jar", "/rest-app.jar"]

