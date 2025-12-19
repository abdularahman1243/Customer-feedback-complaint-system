# 📡 Government Service Management System (GSMS)

Enterprise-grade backend system for managing government telecommunication and public services using **Spring Boot (Java 21)**, **JWT-based security**, **Role-Based Access Control (RBAC)**, **multi-database architecture**, **Redis caching**, **Docker**, and a **CI/CD pipeline**.

---

## 📚 Table of Contents

- [Overview](#-overview)
- [Purpose](#-purpose)
- [Architecture](#-architecture)
- [Database Strategy](#-database-strategy)
- [Security](#-security)
- [RBAC Roles](#-rbac-roles)
- [Domain Models](#-domain-models)
- [Configuration](#-configuration)
- [Run with Docker](#-run-with-docker-recommended)
- [Run Locally](#-run-locally)
- [Testing](#-testing)
- [CI/CD Pipeline](#-cicd-pipeline)
- [REST API Highlights](#-rest-api-highlights)
- [Future Improvements](#-future-improvements)
- [Author](#-author)

---

## 🚀 Overview

GSMS is a production-style backend system that simulates a real government service platform.

Key features:
- Secure authentication and authorization (JWT)
- Role-Based Access Control (RBAC)
- Multi-database architecture (MySQL, MongoDB, Redis)
- Redis caching for performance optimization
- Clean layered architecture
- Fully Dockerized infrastructure
- CI/CD automation
- Unit-tested business logic

---

## 🎯 Purpose

This project demonstrates real-world backend engineering practices, including:

- Secure authentication and authorization
- Fine-grained role-based access control
- Proper use of relational and NoSQL databases
- Clear separation of concerns
- Dockerized deployment
- CI/CD automation
- Testable and maintainable codebase

---

## 🧱 Architecture

```text
Client (Web / Mobile)
        ↓
Spring Boot REST API (Java 21)
        ↓
+----------------------------------+
| MySQL     | Users & Auth (ACID)  |
| MongoDB   | Services & Requests  |
| Redis     | Cache (Performance)  |
+----------------------------------+
```
---
🗄️ Database Strategy
```text

| Database | Usage                         | Reason                             |
| -------- | ----------------------------- | ---------------------------------- |
| MySQL    | Users, Authentication, Roles  | ACID consistency                   |
| MongoDB  | Services and Service Requests | Flexible schema                    |
| Redis    | Caching                       | High performance & reduced DB load |
```

---
## 🔐 Security

Implemented security mechanisms:

JWT-based authentication (stateless)

Spring Security 7

BCrypt password hashing

Method-level and URL-based authorization

Custom UserDetailsService

Secrets managed via environment variables

No credentials or secrets are stored in source code.

---
| Role        | Permissions                         |
| ----------- | ----------------------------------- |
| SUPER_ADMIN | Full system control                 |
| ADMIN       | Manage users and services           |
| OFFICER     | Review and process service requests |
| CITIZEN     | Submit and track service requests   |

---
##🧑‍💼 Domain Models
##👤 User (MySQL)

Authentication and authorization

Government-specific identity fields

Audit fields

UserType:
- SUPER_ADMIN
- ADMIN
- OFFICER
- CITIZEN


Role-specific fields:

CITIZEN → nationalId

OFFICER / ADMIN → employeeCode

---
#🛠️ Government Service (MongoDB)

Examples:

Passport Service

SIM Registration

Telecom Licensing

Features:

Active / inactive management

Managed by ADMIN role
---
📄 Service Request (MongoDB)

Lifecycle:

SUBMITTED → UNDER_REVIEW → APPROVED / REJECTED


Features:

Status history tracking

Citizen ↔ Officer interaction
---
⚙️ Configuration

All sensitive configuration values are provided through environment variables.

Required Environment Variables
MYSQL_PASSWORD=strong_password
JWT_SECRET=very_long_secure_secret


A .env.example file is provided.
Do not commit the actual .env file.
---
🐳 Run with Docker (Recommended)
Prerequisites

Docker

Docker Compose

Start the system
docker-compose up -d --build
---
Running services

MySQL → localhost:3307

MongoDB → localhost:27017

Redis → localhost:6379

Swagger UI
http://localhost:8080/swagger-ui.html

Stop the system
docker-compose down

---
▶️ Run Locally
1. Start infrastructure services
docker-compose up -d

2. Set environment variables
export MYSQL_PASSWORD=strong_password
export JWT_SECRET=secure_secret

3. Run the application
mvn clean spring-boot:run -Dspring-boot.run.profiles=local

---
🧪 Testing

Unit tests cover the service layer with mocked dependencies.

Run tests:

mvn test
---
🔄 CI/CD Pipeline

CI/CD is implemented using GitHub Actions.

Pipeline steps:

Maven build

Unit tests

Docker image build

Triggers:

Push to main

Pull requests to main

---
📌 REST API Highlights
Authentication

POST /api/auth/register

POST /api/auth/login

Services

POST /api/services

GET /api/services

Service Requests

POST /api/requests

GET /api/requests/my
---

🧠 Future Improvements

Audit logging

Event-driven architecture (Kafka)

Notification service

Administrative dashboard frontend
---
👨‍💻 Author

Abdul Rahman “Bahadurzai”
Backend Developer (Spring Boot)
Focused on building secure, scalable, enterprise-grade backend systems


