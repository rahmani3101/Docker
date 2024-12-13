FROM fedora:latest

# Set the working directory in the image
WORKDIR /app

# Copy the files from the host file system to the image file system
COPY . /app

# Install Java and other necessary packages
RUN dnf update -y && \
    dnf install -y java-17-openjdk java-17-openjdk-devel && \
    dnf clean all

# Set environment variables
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk
ENV PATH $PATH:$JAVA_HOME/bin

# Compile the Java application
RUN javac App.java

# Run the Java application
CMD ["java", "App"]
