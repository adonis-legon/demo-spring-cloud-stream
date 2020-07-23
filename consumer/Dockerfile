FROM openjdk:11-jdk-slim
EXPOSE 8080
ARG JAR_FILE=target/demo-spring-cloud-stream-consumer-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]