

# Stage 1: Build the Spring Boot application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Build the final image
FROM openjdk:17.0.1-jdk-slim

# Copy the Spring Boot JAR from the build stage
COPY --from=build /app/target/rain-0.0.1-SNAPSHOT.jar rain.jar

# Expose ports
EXPOSE 8080

# Entrypoint to start the application
ENTRYPOINT [ "java","-jar","rain.jar" ]
