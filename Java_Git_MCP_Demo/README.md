# GitHub MCP Demo - Java Application with Jenkins & Kubernetes

A complete end-to-end demonstration of Java application development with automated CI/CD pipeline and Kubernetes deployment.

## Project Structure

```
Java_Git_MCP_Demo/
├── src/
│   └── main/java/com/example/
│       ├── app/
│       │   └── Application.java
│       └── controller/
│           └── HealthController.java
├── k8s/
│   ├── namespace.yaml
│   ├── deployment.yaml
│   └── service.yaml
├── pom.xml
├── Dockerfile
├── Jenkinsfile
└── README.md
```

## Technologies Used

- **Java 11** - Application development
- **Maven** - Build automation
- **Docker** - Containerization
- **Jenkins** - CI/CD pipeline
- **Kubernetes** - Container orchestration

## Pipeline Stages

### 1. Checkout
- Retrieves source code from repository

### 2. Compile
- Compiles Java source code using Maven

### 3. Build
- Packages the application into JAR

### 4. Test
- Runs unit tests

### 5. Build Docker Image
- Creates Docker image with multi-stage build
- Tags with build number and latest

### 6. Push to Docker Registry
- Pushes image to Docker Hub

### 7. Deploy to Kubernetes
- Creates namespace
- Deploys application
- Exposes service
- Scales replicas

## Kubernetes Deployment Features

- **Replicas**: 3 (default, auto-scales to 10)
- **Resource Limits**: CPU 500m, Memory 1Gi
- **Health Checks**: Liveness and readiness probes
- **LoadBalancer Service**: Exposes on port 80
- **HorizontalPodAutoscaler**: Auto-scales based on CPU/Memory

## How to Run

### Prerequisites
- Maven 3.8.1+
- Docker
- Jenkins
- Kubernetes cluster
- kubectl configured

### Local Build
```bash
mvn clean package
java -jar target/github-mcp-demo-1.0.0.jar
```

### Docker
```bash
docker build -t java-git-mcp-demo:1.0.0 .
docker run -p 8080:8080 java-git-mcp-demo:1.0.0
```

### Kubernetes
```bash
kubectl apply -f k8s/
kubectl get pods -n java-app-namespace
kubectl get svc -n java-app-namespace
```

## Jenkins Configuration

1. Create a new Pipeline job
2. Connect to this GitHub repository
3. Set Pipeline script path to: `Jenkinsfile`
4. Configure Docker Hub credentials
5. Configure Kubernetes credentials
6. Run the pipeline

## Environment Variables

- `JAVA_OPTS`: JVM options (default: `-Xmx512m -Xms256m`)
- `APP_ENV`: Application environment (default: `production`)

## Author

Vijay Kumar

## License

MIT