@WebMvcTest - it will initialize the Spring's web application context (loads only configuration related to the MVC layer - controllers)
In contrast to @SpringBootRest, which loads the entire configuration.

@MockBean - tells Spring not to inject the real bean. We just need to test isolated Controller. We need to configure it later using given() method.

JacksonTester - useful for testing Json's. It can be automatically configured and autowired when using @JsonTest, but when we using @WebMvcTest,
we need to configure it manually.

@SpringBootTest - is more useful in integration tests, when we need to test application from the client side.