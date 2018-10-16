# microservices-v4

This project contains the version 4 of the application that is developed under the scope of the book *Learn Microservices with Spring Boot*. You can get a copy of the book on [Apress](http://www.apress.com/gp/book/9781484231647).

## About this version

This version includes the persistence layer of the application. Now the multiplications, attempts and users are persisted in database.


@WebMvcTest - it will initialize the Spring's web application context (loads only configuration related to the MVC layer - controllers) In contrast to @SpringBootRest, which loads the entire configuration.

@MockBean - tells Spring not to inject the real bean. We just need to test isolated Controller. We need to configure it later using given() method.

JacksonTester - useful for testing Json's. It can be automatically configured and autowired when using @JsonTest, but when we using @WebMvcTest, we need to configure it manually.

@SpringBootTest - is more useful in integration tests, when we need to test application from the client side.
