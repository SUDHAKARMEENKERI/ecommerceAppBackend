# Stage 1: Build the Spring Boot application using Maven
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copy Maven wrapper and configuration
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (this step helps cache dependencies)
RUN ./mvnw dependency:go-offline

# Copy the source code
COPY src src

# Package the application (skip tests for faster build)
RUN ./mvnw package -DskipTests

# Stage 2: Create the final, lightweight runtime image
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder target/dictionaryApp-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app listens on
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
