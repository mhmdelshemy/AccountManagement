# AccountManagement 

Welcome to the AccountManagement microservice , this is a repository for one of the 2 microservices that the account system consist of, you can clone the other microservice using this link : https://github.com/mhmdelshemy/TransactionManagement.git

# Technologies Used :
  - Java 11
  - Spring boot 2.3.3
  - Webclient
  - Spring data jpa
  - H2 in-memory databse
  - Lombok
  - Docker
  - Mockito

# Description 

Account Management is one of the microservices that shapes the Account system , it is a spring boot application which run an in-memory h2 databse to operate the account management operations.

The in-memory database automatically initilize during the application startup with new schema and data , you can find the database schema and data in schema.sql and data.sql

The account management system connects to Transaction management remote service which is responsible for the transactions operations.

The service is using technologies as follows :
  - Spring boot and Rest webservices to popualte the endpoints
  - Webclient to make remote calls to Transaction Management service
  - Spring Data jpa as a persistance layer
  - Lombok as a helper library
  - Junit and Mockito to perform a unit and integration tests
  - Jacoco to generate code coverage report

# How to Run
- After cloning the project , you can just import the project in Inteliij or any preferable IDE , build the project using build tool in IDE or you can build it using maven by ````mvn clean install```` command, then run it using run option in the IDE or you can run it by ````mvn spring-boot:run````
Note : The service is performing some integration tests which is connecting to the Transaction service, so make sure to run it first.
- After running the application you can test the Api's by using swagger using this link : http://localhost:8081/swagger-ui.html 
or by importing the postman collection included in the under the root folder with name  ````AccountManagementCollection.postman_collection.json````
- Make sure to run the Management service before performing any testing activities, because the account management is using Transaction management service.
- I have included a Dockerfile in order to build and run the project as a docker container instead of maven run, but according to some limitation in my working machine , I couldn't been able to build the image and upload it to docker hub, so following commands should build the image and run the container which exposing port 8081 <br>
 1- ````docker build -t account-management . ```` <br>
 2- ````docker run -it -p 8081:8081 account-management````
 - To generate Jacoco report , use command ````mvn clean install```` then use ````mvn jacoco:report```` , and you can find the report as a HTML file in path ````target/site/jacoco/index.html````
 - To track the in-memory database , access http://localhost:8081/h2-console and make sure that you are using ````org.h2.Driver```` as a driver class and ````jdbc:h2:mem:accountmngdb```` as a JDBC URL

