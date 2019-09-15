# Start with a base image containing Java runtime
FROM java:8

# Make port 8181 available to the world outside this container
EXPOSE 8181

ADD target/spring-boot-mongo.jar spring-boot-mongo.jar

# Run the jar file
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/smddev-test", "-jar","spring-boot-mongo.jar"]