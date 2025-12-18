# API Automation Tests

This repository contains automated API tests written in **Java** and built with **Gradle**.

The project uses **Docker** to provide a consistent execution environment and **GitHub Actions** to run tests automatically as part of a Continuous Integration (CI) pipeline.

---

## 🐳 Docker

Docker is used to package the project together with all required dependencies.  
This ensures that the tests run the same way on any machine without requiring a local Java or Gradle setup.

### Build Docker image
docker run --rm api-test

### Run test in Docker Container
docker run --rm api-test

### 🤖 Continuous Integration (GitHub Actions)

This project uses GitHub Actions for Continuous Integration.
The CI pipeline is triggered on:
every push to the repository
every pull request
CI workflow steps
Checkout the repository
Build the Docker image
Run the tests inside a Docker container

### Workflow file location:
.github/workflows/ci.yml

### 🧪 Test Reports

Gradle generates test reports during execution.
When running locally, reports can be found at:
build/reports/tests/test/index.html

## 📦 Technologies Used:

Java
Gradle
Docker
GitHub Actions
REST API testing

## ✅ Benefits of this setup

Reproducible test execution
No local environment dependency issues
Docker-based test execution
Automated CI on every push and pull request
Easy integration into any CI/CD pipeline
