# Docker 

## What is Docker?

Docker is a containerization platform that provides an easy way to containerize your applications. It allows you to:
- Build container images
- Run images to create containers
- Push containers to container registries like DockerHub and Quay.io

## Docker Desktop

Docker Desktop is an easy-to-install application for Mac, Windows, or Linux that enables you to:
- Build and share containerized applications
- Includes key components such as:
  - Docker daemon (dockerd)
  - Docker client
  - Docker Compose
  - Docker Content Trust
  - Kubernetes
  - Credential Helper

## Docker Registries

A Docker registry stores Docker images. Key points:
- Docker Hub is a public registry anyone can use
- Docker is configured to look for images on Docker Hub by default
- You can run your own private registry

### Docker Registry Commands
- `docker pull`: Pull images from a registry
- `docker push`: Push images to a registry
- `docker run`: Run images from a registry

## Docker Objects

When using Docker, you create and use:
- Images
- Containers
- Networks
- Volumes
- Plugins

## Dockerfile

A Dockerfile is a text file that provides step-by-step instructions to build a Docker Image.

## Installation Guide

### Install Docker on Ubuntu

1. Update package list
```bash
sudo apt update
```

2. Install Docker
```bash
sudo apt install docker.io -y
```

### Start Docker and Grant Access

1. Check Docker daemon status
```bash
sudo systemctl status docker
```

2. Start Docker daemon (if not running)
```bash
sudo systemctl start docker
```

3. Grant user access to Docker
```bash
sudo usermod -aG docker <username>
```
Replace `<username>` with your actual username (e.g., ubuntu)

### Verify Installation

Run the hello-world test:
```bash
docker run hello-world
```

## First Docker Image and Container

1. Build your first Docker image
```bash
docker build -t <username>/my-first-docker-image:latest .
```

2. Verify created image
```bash
docker images
```

3. Run your first container
```bash
docker run -it <username>/my-first-docker-image
```

## Additional Resources

- Official Docker Documentation: [https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/)

## Best Practices

- Always use specific image tags instead of `latest`
- Keep your images small
- Use multi-stage builds
- Implement proper security measures

## Contributing

Feel free to contribute to this guide by submitting pull requests or reporting issues.

## Contact

Name : Mohammad Asad Rahmani
email : asadrahmani3101@gmail.com
