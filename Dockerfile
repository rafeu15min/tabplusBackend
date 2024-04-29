FROM openjdk:21-slim  
WORKDIR /app
COPY pom.xml ./
RUN mvn clean install
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
