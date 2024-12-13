###########################################
# BASE IMAGE
###########################################
FROM ubuntu:latest

# Update package lists and install Java Development Kit
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the Java source file
COPY Calculator.java .

# Compile the Java application
RUN javac Calculator.java

# Create an entrypoint script to run the calculator
RUN echo '#!/bin/bash\njava InteractiveScientificCalculator' > /entrypoint.sh && \
    chmod +x /entrypoint.sh

# Set the entrypoint
ENTRYPOINT ["/entrypoint.sh"]
