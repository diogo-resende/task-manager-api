# Task Manager API

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-4.x-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-brightgreen)
![Status](https://img.shields.io/badge/Status-Learning%20Project-yellow)

A RESTful API built with **Spring Boot** for managing users and tasks.

This project was developed as a **backend learning project** focusing on:

* clean architecture
* DTO usage
* validation
* exception handling
* standardized API responses

---

# 📌 Features

### Users

* Create user
* List users
* Get user by ID
* Update user
* Delete user

### Tasks

* Create task
* List tasks
* Get task by ID
* Delete task
* Get tasks by user

---

# 🛠 Technologies

* Java 25
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Hibernate
* Jakarta Validation
* Lombok
* Swagger / OpenAPI

---

# 🏗 Architecture

This project follows a **layered architecture**.

```
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

Responsibilities:

Controller
Handles HTTP requests and responses.

Service
Contains business logic.

Repository
Handles database operations using JPA.

DTO
Separates API responses from database entities.

---

# 📂 Project Structure

```
src/main/java/com/diogo_resende/task_manager_api

controller
service
repository
entity
dto
exception
response
config
```

---

# 📦 Example API Response

The API uses a **standard response format**.

```json
{
  "timestamp": "2026-03-11T12:00:00",
  "status": 200,
  "message": "Users retrieved successfully",
  "data": [...]
}
```

---

# 📸 Swagger Documentation

Swagger UI provides interactive API documentation.

After running the application, access:

```
http://localhost:8080/swagger-ui/index.html
```

Example interface:

*(add a screenshot here)*

![Swagger UI](docs/swagger-example.png)

---

# 🚀 Running the Project

### 1 Clone the repository

```
git clone https://github.com/yourusername/task-manager-api.git
```

### 2 Configure PostgreSQL

Edit the `application.properties` file with your database credentials.

### 3 Run the project

```
./mvnw spring-boot:run
```

or run directly from your IDE.

---

# 📚 Learning Goals

This project was created to practice:

* REST API development
* Spring Boot architecture
* DTO patterns
* validation
* error handling
* clean code practices

---

# 🔮 Future Improvements

* Pagination
* Unit tests
* Authentication (JWT)
* Docker support
* Logging

---

# 👨‍💻 Author

Developed by **Diogo Resende** as part of backend learning and portfolio building.
