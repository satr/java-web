# syntax=docker/dockerfile:1

# Build stage
FROM eclipse-temurin:24-jdk AS builder
WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon --refresh-dependencies

# Run stage
FROM eclipse-temurin:24-jre
RUN apt-get update && apt-get install -y curl
WORKDIR /app
COPY --from=builder /app/build/libs/springapp-*-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
