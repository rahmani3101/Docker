# Java Scientific Calculator - Multistage Docker Build

## Prerequisites
- Docker
- Docker Compose

## Key Features of Multistage Build
- First stage (Ubuntu): Compiles Java source code
- Second stage (Alpine JRE): Creates a lightweight runtime image
- Reduces final image size
- Separates build-time and runtime dependencies

## Building and Running

1. Clone the repository
2. Navigate to the project directory
3. Build and run the calculator:

```bash
docker-compose up --build
```

## Advantages
- Smaller final image size
- No build tools in the final image
- Improved security by minimizing image layers

## Supported Operations
- Basic Arithmetic: +, -, *, /, ^, %
- Scientific Operations: log, root

## Exiting
- Enter '0' to exit the calculator
