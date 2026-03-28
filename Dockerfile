FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN apt-get update && apt-get install -y maven

# Skip tests & DB issues
RUN mvn clean package -DskipTests -Dmaven.test.skip=true

ENTRYPOINT ["java","-jar","target/*.jar"]