# Multi-stage Docker build for Java application
FROM maven:3.8.1-openjdk-11 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 \
    CMD java -cp app.jar com.example.controller.HealthController || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]