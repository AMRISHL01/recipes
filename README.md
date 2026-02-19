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

### Recipes (`/api/recipes`)

| Method | Endpoint | Description | Request Body | Params |
| :--- | :--- | :--- | :--- | :--- |
| `POST` | `/add` | Add a new recipe | JSON Recipe object | - |
| `GET` | `/` | Get all recipes (paginated) | - | `page` (default 1), `limit` (default 5) |
| `GET` | `/search` | Search recipes | - | `title`, `cuisine`, `totalTime`, `rating`, `page`, `limit` |

### Hello (`/`)

*   `GET /hello`: Returns a simple greeting to verify the application is running.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
