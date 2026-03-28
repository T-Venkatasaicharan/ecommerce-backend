# Use Java 17
FROM eclipse-temurin:17-jdk

# Copy project files
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the jar
ENTRYPOINT ["java","-jar","target/*.jar"]