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
- PostgreSQL
- Flyway (database migrations)
- MapStruct (DTO/entity mapping)
- Testcontainers (integration testing)
- Swagger/OpenAPI for API documentation

## Running the Project
1. Build all modules using Gradle:
   ```sh
   ./gradlew build
   ```
2. Start all services and the database using Docker Compose:
   ```sh
   docker-compose up
   ```
3. Access the Swagger UI for API documentation:
   [Swagger UI](http://localhost:8080/openapi/swagger-ui.html)

## Microservices Overview
- Each microservice has its own `build.gradle` and `Dockerfile`.
- Services communicate via REST APIs.
- The composite service provides a unified endpoint for clients.
- Persistence is implemented using JPA and Spring Data.
- Database migrations are managed by Flyway.
- MapStruct is used for mapping between entities and DTOs.
- Integration and repository tests use Testcontainers for isolated database environments.

## Database and Docker Compose
- All microservices use a single PostgreSQL container with three separate databases (`product-db`, `recommendation-db`, `review-db`).
- Microservices depend on healthy database startup (configured in `docker-compose.yml`).
- Flyway migration scripts are located in each service under `src/main/resources/db/migration/`.

## Project Structure Details
- `microservices/<service>/src/main/java/.../entity/`: JPA entities
- `microservices/<service>/src/main/java/.../repository/`: Spring Data repositories
- `microservices/<service>/src/main/java/.../service/`: Service layer
- `microservices/<service>/src/main/java/.../mapper/`: MapStruct mappers
- `microservices/<service>/src/main/resources/db/migration/`: Flyway migration scripts
- `microservices/<service>/src/test/java/.../`: Testcontainers-based tests

## API Documentation
- Swagger UI is available at: `http://localhost:8080/openapi/swagger-ui.html`

---

For more details, explore the source code in each module and refer to the API documentation.
