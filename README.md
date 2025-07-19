
# Product Review Microservices

This project is a microservices-based product review system, designed to demonstrate a modular architecture using Java and Gradle. Each microservice is responsible for a specific domain within the product review ecosystem.

## Project Structure

- **api/**: Shared API definitions and interfaces used across microservices.
- **util/**: Utility classes and shared logic for the project.
- **microservices/**: Contains the main microservices:
  - **product-service/**: Manages product data and operations.
  - **review-service/**: Handles product reviews.
  - **recommendation-service/**: Provides product recommendations.
  - **product-composite-service/**: Aggregates data from other services to provide a unified API.
- **docker-compose.yml**: Used to orchestrate all services for local development and testing.
- **README.md**: Project documentation and instructions.

## Technologies Used
- Java
- Gradle (multi-module setup)
- Docker
- Swagger/OpenAPI for API documentation

## Running the Project
1. Build all modules using Gradle:
   ```sh
   ./gradlew build
   ```
2. Start all services using Docker Compose:
   ```sh
   docker-compose up
   ```
3. Access the Swagger UI for API documentation:
   [Swagger UI](http://localhost:8080/openapi/swagger-ui.html)

## Microservices Overview
- Each microservice has its own `build.gradle` and `Dockerfile`.
- Services communicate via REST APIs.
- The composite service provides a unified endpoint for clients.

## API Documentation
- Swagger UI is available at: `http://localhost:8080/openapi/swagger-ui.html`

---

For more details, explore the source code in each module and refer to the API documentation.

