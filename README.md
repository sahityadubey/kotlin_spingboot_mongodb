# 📘 Backend Development Crash Course 2025
### Spring Boot · Kotlin · JWT Auth · MongoDB

---

## 🎯 Overview

This project demonstrates a full-stack backend setup built with modern technologies. It includes user authentication with JWT, MongoDB for data persistence, and a clean, scalable architecture using Kotlin and Spring Boot.

---

## 🛠️ Technologies Used

- 🧬 **Kotlin** – Primary programming language
- 🚀 **Spring Boot** – Backend framework
- 🔐 **JWT (JSON Web Tokens)** – Secure API authentication
- 🍃 **MongoDB** – NoSQL document database

---

## 🧱 Project Structure

```
├── config/        # Security and app configurations
├── controller/    # API endpoints and request handling
├── model/         # Data classes and DTOs
├── repository/    # Interfaces for MongoDB CRUD
└── service/       # Business logic layer
```

---

## 🔧 Spring Boot Setup

- Built with Kotlin and Spring Boot
- Key dependencies: Spring Web, Spring Security, Spring Data MongoDB, JWT
- MongoDB connection and server settings configured in `application.yml`

---

## 🔐 JWT Authentication Flow

1. **Register** – Users submit their details (username, email, password)
2. **Login** – Returns a JWT token upon valid credentials
3. **Authenticated Requests** – Token is sent via the `Authorization` header

The JWT includes claims (e.g., username, expiry), and is validated through a custom filter on each request.

---

## 🗃️ MongoDB Integration

- Uses Spring Data MongoDB
- Repositories extend `MongoRepository` for built-in CRUD support
- Documents like `User` and `Note` are stored in MongoDB collections

---

## 📒 Application Features

### 👤 User Authentication

- Passwords hashed using `BCryptPasswordEncoder`
- `UserDetailsService` loads user information securely

### 📄 Notes API

| Method | Endpoint          | Description              |
|--------|-------------------|--------------------------|
| POST   | `/api/notes`      | Create a new note        |
| GET    | `/api/notes`      | List user's notes        |
| DELETE | `/api/notes/{id}` | Delete a note by its ID  |

---

## 🔐 Security Configuration

- Public routes: `/register`, `/login`
- All other routes protected via JWT
- CORS and CSRF configurations adjusted for frontend integration

---

## 📦 Example Requests

### 🔸 Registration

```json
{
  "username": "exampleUser",
  "email": "user@example.com",
  "password": "password123"
}
```

### 🔸 Login Response

```json
{
  "token": "eyJhbGciOiJIUzI1NiIs..."
}
```

---

## ✅ Summary

- Developed RESTful APIs with Spring Boot and Kotlin
- Integrated MongoDB for data persistence
- Implemented secure JWT authentication
- Designed using clean modular architecture

---

## 📈 Further Improvements

- Add note update/edit functionality
- Introduce refresh tokens for session renewal
- Connect with a frontend framework (e.g., React, Angular)

---

📚 _Feel free to fork, clone, and build on top of this starter project!_