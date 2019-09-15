FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM java:8

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/spring-boot-mongo*.jar spring-boot-mongo.jar

EXPOSE 8181

ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/smddev-test", "-jar","spring-boot-mongo.jar"]