# syntax=docker/dockerfile:1

# Build stage
FROM eclipse-temurin:24-jdk AS builder
WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon --refresh-dependencies

# Run stage
FROM eclipse-temurin:24-jre
WORKDIR /app
COPY --from=builder /app/build/libs/api-*-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
