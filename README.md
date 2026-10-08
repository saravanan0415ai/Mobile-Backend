# Spring Boot Backend

This is the backend for the MRA application, built with Java, Spring Boot, and MySQL.

## Prerequisites
- Java 17 or higher
- Maven (or use the included `./mvnw` wrapper)
- MySQL Server

## Configuration
Before running the application, ensure that you have created the MySQL database:
```sql
CREATE DATABASE mra_db;
```

If your MySQL username/password is different from `root`/`root`, update `src/main/resources/application.properties`:
```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Running the Application
To run the backend server, execute:
```sh
./mvnw spring-boot:run
```
The server will start on port 8080.

## API Endpoints
The frontend is already configured to talk to these endpoints:
- `GET /api/users` - Get all users
- `POST /api/users` - Create a new user
- `PUT /api/users/{id}` - Update a user
- `DELETE /api/users/{id}` - Delete a user
- `POST /api/users/login` - Authenticate a user
