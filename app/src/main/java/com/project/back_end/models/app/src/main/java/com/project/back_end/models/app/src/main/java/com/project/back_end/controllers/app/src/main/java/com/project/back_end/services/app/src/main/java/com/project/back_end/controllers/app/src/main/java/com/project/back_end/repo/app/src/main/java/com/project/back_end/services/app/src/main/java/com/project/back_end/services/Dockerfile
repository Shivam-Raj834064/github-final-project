
# Use a Java runtime image
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

# Copy the application files
COPY . .

# Expose the application port
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "app.jar"]
