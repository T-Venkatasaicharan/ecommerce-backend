FROM eclipse-temurin:17-jdk

COPY . .

RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

ENTRYPOINT ["java","-jar","target/*.jar"]