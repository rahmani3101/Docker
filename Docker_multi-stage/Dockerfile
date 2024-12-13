###########################################
# BUILD STAGE
###########################################
FROM ubuntu:latest AS build

# Install JDK
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy the source file
COPY InteractiveScientificCalculator.java .

# Compile the Java application
RUN javac InteractiveScientificCalculator.java

############################################
# RUNTIME STAGE
############################################
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy compiled class files from build stage
COPY --from=build /app/InteractiveScientificCalculator.class .

# Set the entrypoint
ENTRYPOINT ["java", "InteractiveScientificCalculator"]
