FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY ecommerce/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]