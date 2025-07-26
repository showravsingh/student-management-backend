# Stage 1: Build the WAR using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy all project files into the container
COPY . .

# Run Maven to build the WAR (skips tests if needed)
RUN mvn clean package -DskipTests

# Stage 2: Use Tomcat to serve the WAR
FROM tomcat:9.0-jdk17-temurin

# Clean the default webapps folder
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built WAR file into the Tomcat webapps folder as ROOT.war
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose the default Tomcat port
EXPOSE 8080
