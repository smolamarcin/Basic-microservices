FROM openjdk:8
VOLUME /tmp
COPY target/gateway-1.0.0.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]