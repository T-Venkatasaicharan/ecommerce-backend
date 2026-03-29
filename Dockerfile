FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy full project
COPY . .

# Move into inner project (VERY IMPORTANT)
WORKDIR /app/ecommerce

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build project
RUN mvn clean package -DskipTests

# Run app
ENTRYPOINT ["java","-jar","target/*.jar"]