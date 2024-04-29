FROM maven:3.9.6-amazoncorretto-21-debian as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:21-ea-10-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./tabplus.jar
ENTRYPOINT java -jar tabplus.jar