FROM openjdk:8-jdk-alpine AS build

RUN MAVEN_VERSION=3.5.0 \
 && cd /usr/share \
 && wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz -O - | tar xzf - \
 && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
 && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

WORKDIR /home/lab

COPY pom.xml .
RUN mvn verify -DskipTests --fail-never

COPY src ./src
RUN mvn verify

FROM openjdk:8-jre-alpine

ENTRYPOINT ["java", "-jar", "/app/gamification-0.0.1-SNAPSHOT.jar"]

WORKDIR /app
COPY --from=build /home/lab/target .