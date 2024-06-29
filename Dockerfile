# Use an official Maven image to build the application
FROM --platform=linux/amd64 openjdk:23-jdk-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the application
RUN mvn clean install -DskipTests

# Use an official OpenJDK runtime as a parent image
FROM --platform=linux/amd64 openjdk:23-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file from the build stage
COPY --from=build /app/target/app.jar /app/app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
