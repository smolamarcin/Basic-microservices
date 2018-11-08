FROM openjdk:8
VOLUME /tmp
COPY target/social-multiplication-v4-0.4.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]