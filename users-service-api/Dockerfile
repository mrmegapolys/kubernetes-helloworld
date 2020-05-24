FROM openjdk:8-jdk-alpine
WORKDIR /app
EXPOSE 8080
ADD ./build/libs/users-service-api-0.0.9-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "users-service-api-0.0.9-SNAPSHOT.jar"]