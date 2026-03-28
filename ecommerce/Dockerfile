# Use Java 17
FROM openjdk:17-jdk-slim

# Copy project files
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the jar
ENTRYPOINT ["java","-jar","target/*.jar"]