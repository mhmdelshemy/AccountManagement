FROM openjdk:11-jdk-slim

LABEL maintainer="mhmd.elshemy@gmail.com"

FROM maven:3.6-alpine
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the project source
COPY src src

EXPOSE 8081
# Package the application
RUN mvn package -DskipTests
ENV JAR_FILE=target/account-management-0.0.1-SNAPSHOT.jar
RUN mv ${JAR_FILE} /account-management.jar
ENTRYPOINT ["java","-jar","account-management.jar"]
