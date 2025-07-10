# Use OpenJDK image as base
FROM openjdk:21-jdk-slim

# Set environment variable
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""

# Set working directory
WORKDIR /app

# Copy the built JAR to the container
COPY target/notesApp-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
