# 📝 Blog Management System

A complete **Blog Management REST API** built using **Spring Boot** as part of my Backend Internship.

This project demonstrates the implementation of modern backend development concepts including REST APIs, Spring Security, JWT Authentication, JPA/Hibernate, PostgreSQL, Unit Testing, Swagger Documentation, File Uploads, Pagination, Searching, and Role-Based Authorization.

---

# 🚀 Features

## 🔐 Authentication & Security

- User Registration
- User Login
- JWT Authentication
- Spring Security
- Password Encryption (BCrypt)
- Role-Based Authorization

---

## 👤 User Management

- Register User
- Login User
- Get All Users
- Get User By Username
- Update User
- Delete User
- Password Encryption

---

## 📝 Blog Post Management

- Create Post
- Get All Posts
- Get Post By ID
- Update Post
- Delete Post
- Search Posts
- Pagination
- Sorting

---

## 📂 File Upload

- Upload Images
- Store File Path
- Retrieve Uploaded Files

---

## 📖 API Documentation

- Swagger UI
- OpenAPI Documentation

---

## ✅ Validation

- Bean Validation
- Request Validation
- Global Exception Handling

---

## 🧪 Testing

- Unit Testing
- Integration Testing
- JUnit 5
- Mockito
- Spring Security Test

---

# 🛠 Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Hibernate ORM
- PostgreSQL
- JWT (JSON Web Token)
- Maven
- Swagger (OpenAPI)
- Lombok
- JUnit 5
- Mockito
- Postman
- IntelliJ IDEA

---

# 📁 Project Structure

```text
src
│
├── config
├── controller
├── entity
├── repository
├── service
├── security
├── exception
├── util
├── dto
└── BlogappApplication.java
```

---

# 🗄 Database

### User Table

| Column | Type |
|---------|------|
| id | Long |
| username | String |
| email | String |
| password | String |

---

### Post Table

| Column | Type |
|---------|------|
| id | Long |
| title | String |
| content | String |
| category | String |
| createdAt | LocalDateTime |

---

# 🔑 Authentication Flow

```
Register User
        │
        ▼
Password Encrypted using BCrypt
        │
        ▼
Login
        │
        ▼
JWT Token Generated
        │
        ▼
Bearer Token
        │
        ▼
Access Protected APIs
```

---

# 📬 REST API Endpoints

## Authentication

| Method | Endpoint |
|---------|----------|
| POST | /day14/auth/register |
| POST | /day14/auth/login |

---

## Users

| Method | Endpoint |
|---------|----------|
| GET | /day14/users |
| GET | /day14/users/{username} |

---

## Posts

| Method | Endpoint |
|---------|----------|
| POST | /posts |
| GET | /posts |
| GET | /posts/{id} |
| PUT | /posts/{id} |
| DELETE | /posts/{id} |

---

# ▶️ How to Run

### Clone Repository

```bash
git clone https://github.com/verma2004kartik-design/blogapp.git
```

---

### Open Project

Open using IntelliJ IDEA

---

### Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/blog_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```

---

### Run Project

```
Run BlogappApplication.java
```

---

### Open Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

# 🧪 Testing

Use

- Postman
- Swagger UI

for testing all APIs.

---

# 📚 Internship Progress

| Day | Topics Covered |
|------|----------------|
| Day 1 | Spring Boot Setup |
| Day 2 | REST APIs |
| Day 3 | CRUD Operations |
| Day 4 | Validation |
| Day 5 | Exception Handling |
| Day 6 | Layered Architecture |
| Day 7 | JPA Relationships |
| Day 8 | Pagination |
| Day 9 | Sorting |
| Day 10 | Search |
| Day 11 | Spring Security |
| Day 12 | User Authentication |
| Day 13 | JWT Authentication |
| Day 14 | User Management using JWT |
| Day 15 | Unit Testing |
| Day 16 | Integration Testing |

---

# 👨‍💻 Developed By

**Kartik Verma**

Backend Developer (Spring Boot)

B.Tech Computer Science Engineering