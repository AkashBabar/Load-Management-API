# Load Management System

## 📌 Overview
The **Load Management System** is a Spring Boot-based REST API that enables users to manage loads efficiently. It provides CRUD operations for load management with a PostgreSQL database.

## 🚀 Features
- Create, Read, Update, and Delete (CRUD) operations for load management
- Uses **Spring Boot** and **Spring Data JPA** for seamless database interaction
- PostgreSQL as the database
- **Logging with SLF4J & Logback**
- **Exception handling** for better API stability

---

## 🏗️ Tech Stack
- **Backend**: Java 21, Spring Boot 3.2.2, Spring Data JPA
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Version Control**: Git & GitHub

---

## 🛠️ Installation & Setup
### 🔹 Prerequisites
Ensure you have the following installed:
- **Java 21**
- **Maven**
- **PostgreSQL**
- **Git**

### 🔹 Clone the Repository
```sh
$ git clone https://github.com/AkashBabar/Load-Management-Api.git
$ Load-Management-Api
```

### 🔹 Configure Database
1. Create a **PostgreSQL database**:
   ```sql
   CREATE DATABASE liveasy;
   ```
2. Create a schema inside PostgreSQL:
   ```sql
   CREATE SCHEMA liveasy_schema;
   ```
3. **Set up `application.properties`**:
   - Inside `src/main/resources/`, create a file **`application.properties`**.
   - Copy the content from `application.example.properties` and update it:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/liveasy?currentSchema=liveasy_schema
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     spring.datasource.driver-class-name=org.postgresql.Driver

     server.port=8081

     spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     spring.jpa.properties.hibernate.format_sql=true
     spring.jpa.properties.hibernate.default_schema=liveasy_schema
     ```

### 🔹 Build and Run the Application
```sh
$ mvn clean install
$ mvn spring-boot:run
```

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| **POST** | `/load` | Create a new load |
| **GET** | `/load` | Fetch all loads (or filter by `shipperId`) |
| **GET** | `/load/{loadId}` | Fetch a load by ID |
| **PUT** | `/load/{loadId}` | Update a load by ID |
| **DELETE** | `/load/{loadId}` | Delete a load by ID |

---

## 📂 Project Structure
```
load-management/
│── src/main/java/com/liveasy/loadmanagement
│   ├── controller/          # REST API controllers
│   ├── models/              # Entity & DTO classes
│   ├── repository/          # JPA repository interfaces
│   ├── service/             # Business logic services
│   ├── exception/           # Custom exceptions
│── src/main/resources/
│   ├── application.properties (Ignored in Git)
│   ├── application.example.properties
│── pom.xml                  # Maven dependencies
│── README.md                # Project Documentation
```

---

## 📜 Contribution
Want to improve this project? Follow these steps:
1. **Fork** the repository
2. **Create** a new branch (`git checkout -b feature-xyz`)
3. **Commit** your changes (`git commit -m 'Add feature xyz'`)
4. **Push** to your fork (`git push origin feature-xyz`)
5. **Create a Pull Request**

---

## 🛡️ License
This project is licensed under the **MIT License**.

---

## 📞 Contact
**Developer**: Akash Babar  
📧 Email: [aakashbabar9192@gmail.com](aakashbabar9192@gmail.com)  
🔗 GitHub: [github.com/AkashBabar](https://github.com/AkashBabar)  

---

🚀 **Happy Coding!**

