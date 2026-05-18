# Use an official OpenJDK runtime as a parent image, check the Image version with the Java version you are using in your application and configure the same in the Dockerfile.
FROM openjdk:17-jdk-slim
# Set the working directory in the container (A folder inside the container where the application will be stored).
WORKDIR /app
# Copy the jar file from the target directory to the container
COPY target/peer-prog-0.0.1-dev.jar app.jar
# Expose the port that the application will run on
EXPOSE 8081
# Run the jar file when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
