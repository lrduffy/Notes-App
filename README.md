# Notes-App 📝

A notes management application built with **Java 21**, **Spring Boot**, and **PostgreSQL**. The app provides RESTful endpoints to create, update, delete, and retrieve notes. Docker support is included for easy deployment, and Swagger is integrated for API documentation.

---
  
## 🚀 Features

- ✅ CRUD operations for notes
- 📘 RESTful API design
- 🧪 API documentation via Swagger UI
- 🐘 PostgreSQL database integration
- 🐳 Docker support (Docker Compose)
- ♻️ Java 21 and Spring Boot 3.x

---

## 🛠️ Tech Stack

| Layer        | Technology                  |
|--------------|-----------------------------|
| Language     | Java 21                     |
| Framework    | Spring Boot                 |
| API Docs     | Swagger / SpringDoc OpenAPI |
| Database     | PostgreSQL                  |
| Container    | Docker, Docker Compose      |
| Build Tool   | Maven                       |

---

## 📦 Getting Started

### 🔧 Prerequisites

- Java 21
- Maven
- Docker & Docker Compose
- Git

### 🐳 Run with Docker


```bash
# Clone repository
git clone https://github.com/lrduffy/Notes-App.git
cd Notes-App

# Build and run with Docker
docker-compose up --build
```
Access the application at:

- API:  `http://localhost:8080/api/notes`
- Swagger UI: `http://localhost:8080/swagger-ui.html`

### 💻 Run Locally (Without Docker)

1. Create a PostgreSQL database:

```sql
CREATE DATABASE notes_db;
```
2. Update your `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/notes_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build and run:

```bash
./mvnw spring-boot:run
```

## 📚 API Documentation

Once the app is running, visit:  
`http://localhost:8080/swagger-ui.html`  
to explore and test the API using Swagger UI.

## 🧪 Testing

Run all tests with:

```bash
./mvnw test
```
## 🤝 Contributing

Contributions, issues and feature requests are welcome!  
To contribute:
1. Fork this repository
2. Create a feature branch: `git checkout -b feature/awesome-feature`
3. Commit your changes: `git commit -m 'Add awesome feature'`
4. Push to the branch: `git push origin feature/awesome-feature`
5. Create a pull request

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for details.

## 📬 Contact

Created by [@lrduffy](https://github.com/lrduffy)
Project URL: https://github.com/lrduffy/Notes-App
