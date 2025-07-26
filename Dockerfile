# Use Maven to build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a lighter JRE image to run the JAR
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/StudentManagementSystem.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
