FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy full project
COPY . .

# Go into inner project
WORKDIR /app/ecommerce

# Install maven
RUN apt-get update && apt-get install -y maven

# Build project
RUN mvn clean package -DskipTests

# Run jar
ENTRYPOINT ["java","-jar","target/*.jar"]