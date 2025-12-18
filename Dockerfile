# Build & run tests using Gradle Wrapper
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy everything
COPY . .

# Gradle wrapper must be executable on Linux
RUN chmod +x ./gradlew

# (Optional) speed up gradle in containers
ENV GRADLE_OPTS="-Dorg.gradle.daemon=false"

# Run tests (container will exit after)
CMD ["./gradlew", "test"]
