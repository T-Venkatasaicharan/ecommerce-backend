FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

WORKDIR /app/ecommerce

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

ENTRYPOINT ["java","-jar","target/ecommerce-0.0.1-SNAPSHOT.jar"]