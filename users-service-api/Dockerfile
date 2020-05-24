FROM openjdk:8-jdk-alpine
WORKDIR /app
EXPOSE 8080 8090
ADD ./build/libs/users-service-api-0.0.6-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "users-service-api-0.0.6-SNAPSHOT.jar"]