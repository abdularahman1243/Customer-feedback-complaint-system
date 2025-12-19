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
