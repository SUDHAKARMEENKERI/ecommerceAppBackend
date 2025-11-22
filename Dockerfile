# Stage 1: Build the Spring Boot application
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle .
COPY src src

RUN chmod +x gradlew
RUN ./gradlew bootJar -x test

# Stage 2: Create the final, lightweight runtime image
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the executable JAR from the builder stage
COPY --from=builder /app/build/libs/dictionaryApp-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app listens on
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
