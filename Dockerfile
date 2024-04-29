FROM maven:4.0.0-amazoncorretto-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:21-ea-10-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./tabplus.jar
ENTRYPOINT java -jar springdeskcurso.jar