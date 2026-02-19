# Recipes Application

A Spring Boot application for managing recipes.

## Description

This project is a backend service for a recipe management system. It allows users to create, read, update, and delete recipes. It is built using Spring Boot and uses MySQL as the database.

## Prerequisites

*   Java 17 or later
*   Maven 3.6 or later
*   MySQL 8.0 or later

## Setup

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/AMRISHL01/recipes.git
    cd recipes
    ```

2.  **Configure the database:**
    *   Create a MySQL database named `recipes_db` (or whatever you configured in `application.properties`).
    *   Update `src/main/resources/application.properties` with your database credentials:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/recipes_db?useSSL=false&serverTimezone=UTC
        spring.datasource.username=YOUR_USERNAME
        spring.datasource.password=YOUR_PASSWORD
        ```

3.  **Build the application:**
    ```bash
    mvn clean install
    ```

## Running the Application

To run the application, use the following command:

```bash
mvn spring-boot:run
```

The application will start on port 8080 (default).

## API Endpoints

(List key API endpoints here if applicable, or link to Swagger UI if enabled)

## License

[License Name]
