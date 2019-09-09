FROM java:11
ADD Application.java .
RUN javac Application.java
CMD ["java", "Application"]