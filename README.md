# 🎓 Student Management REST API

A simple RESTful API built with **Spring Boot 3+** to manage student data including adding, updating, retrieving, and deleting records.  
This project uses **Spring Data JPA** with a **MySQL database**.

---

## ⚙️ Technologies Used
- Spring Boot 3+
- Spring Web
- Spring Data JPA
- Hibernate Validation
- MySQL Database
- Maven

---

## 🧱 Project Setup & Run Steps

### 1️⃣ Clone or Download the Project
```bash
git clone https://github.com/mathivarman/Assignment01-Microservices-and-Cloud-Computing.git
2️⃣ Open the Project
Open the folder in IntelliJ IDEA (or any IDE that supports Spring Boot).

3️⃣ Create the Database
In MySQL:

CREATE DATABASE db_student_api;
4️⃣ Configure Database Connection
In src/main/resources/application.properties:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_student_api
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
server.port=8080

5️⃣ Run the Application
Run the main class:
StudentmanagementApplication.java

The application will start on:
http://localhost:8080

📡 API Endpoints
Method	Endpoint	Description
POST	/api/students	Add a new student
GET	/api/students	Retrieve all students
GET	/api/students/{id}	Retrieve student by ID
PUT	/api/students/{id}	Update a student
DELETE	/api/students/{id}	Delete a student
GET	/api/students/search?name={name}	Search by name
GET	/api/students/search?course={course}	Search by course

## REST API Endpoints (Detailed)

### 1. Create Student

POST /api/v1/students

Request Body:

```json
{
  "name": "mathivarman",
  "email": "mathi2gmail.com",
  "course": BICT",
  "age": 24
}
```

## Docker (optional)

Follow these steps to containerize and run the application with Docker.

1) Build the Spring Boot jar

```powershell
cd studentmanagement
.\mvnw.cmd -DskipTests package
```

# Student Management REST API

A simple Spring Boot 3+ REST API for managing student records (create, read, update, delete). It uses Spring Data JPA for persistence and is designed to work with a MySQL database. The project is Maven-based and includes optional Docker support.

## Technologies
- Java, Spring Boot 3+
- Spring Web
- Spring Data JPA (Hibernate)
- Jakarta Bean Validation
- MySQL
- Maven
- Docker (optional)

## Quick start

1. Clone the repository
```powershell
git clone https://github.com/mathivarman/Assignment01-Microservices-and-Cloud-Computing.git
cd Assignment01-Microservices-and-Cloud-Computing
```

2. Create the database in MySQL (example)
```sql
CREATE DATABASE db_student_api;
```

3. Configure database connection

Open `src/main/resources/application.properties` and set your MySQL connection:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_student_api
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
server.port=8080
```

4. Run the application

From your IDE run the main class `StudentmanagementApplication.java`, or from the project root run:

```powershell
.\mvnw.cmd spring-boot:run
```

The app will start on: http://localhost:8080

## Docker (optional)

Build and run with Docker (PowerShell examples):

1) Build the jar (optional — the Dockerfile performs a build during image creation):
```powershell
.\mvnw.cmd -DskipTests package
```

2) Build Docker image (multi-stage Dockerfile included):
```powershell
docker build -t student-management-app .
```

3) Run the container:
```powershell
docker run -p 8080:8080 student-management-app
```

4) Or run with docker-compose (provided `docker-compose.yml` starts MySQL + the app):
```powershell
docker-compose up --build
```

Notes:
- If your artifactId/version differ, update the `Dockerfile` jar name accordingly.
- The repository includes a multi-stage `Dockerfile`, so `docker build` will run `mvn package` inside the build stage unless you provide the compiled jar.

## API Endpoints

Base path used in examples: `/api/v1/students`

| Method | Endpoint | Description |
|---|---:|---|
| POST | /api/v1/students | Create a new student |
| GET | /api/v1/students | Retrieve all students |
| GET | /api/v1/students/{id} | Retrieve a student by ID |
| PUT | /api/v1/students/{id} | Update a student |
| DELETE | /api/v1/students/{id} | Delete a student |
| GET | /api/v1/students/search?name={name} | Search students by name |
| GET | /api/v1/students/search?course={course} | Search students by course |

## Example Requests

Create student (POST /api/v1/students)
```json
{
  "name": "Mathivarman",
  "email": "mathi@example.com",
  "course": "BICT",
  "age": 24
}
```

Update student (PUT /api/v1/students/{id})
```json
{
  "name": "Mathi Updated",
  "email": "mathiupdated@example.com",
  "course": "Software Engineering",
  "age": 22
}
```

## Validation Rules

Field | Rule
---|---
name | must not be blank
email | must be valid and unique
course | must not be blank
age | must be ≥ 19

If validation fails, the API returns a 400 Bad Request with details (see Error Responses).

## Global Exception Handling

The application provides centralized, consistent error responses with the following fields:
- timestamp — ISO-8601 timestamp of the error
- status — HTTP status code
- error/message — short error message
- errors — list or map of field validation errors (if any)

Common handled exceptions:
- ResourceNotFoundException → 404 Not Found
- MethodArgumentNotValidException → 400 Bad Request (validation errors)
- Exception → 500 Internal Server Error

Example validation error response:
```json
{
  "timestamp": "2025-11-07T12:34:56Z",
  "status": 400,
  "error": "Validation Failed",
  "errors": {
    "email": "Email must be valid",
    "age": "Age must be at least 19"
  }
}
```

## How to Test
- Use Postman / HTTPie / curl to call the endpoints above.
- Verify the `db_student_api` MySQL database contains student records.

Example: Get all students
```powershell
curl http://localhost:8080/api/v1/students
```

## Project structure (high level)
- `src/main/java/com/example/studentmanagement/` — main app code
  - `controller/` — REST controllers
  - `service/` — business logic
  - `repository/` — Spring Data JPA repos
  - `model/` — entity classes
  - `exception/` — custom exceptions & handlers
- `src/main/resources/application.properties` — configuration

## Author
Name: Mathivarman  
Index Number: ICT21887  
Course: BICT (Hons) — University of Sri Jayewardenepura  
Subject: ITS 4243 — Microservices and Cloud Computing

---

Completion summary:
- Rewrote and polished the README with clear setup steps, Docker guidance, endpoints, examples, validation and error handling details.
- If you want, I can also apply minor fixes to `application.properties` or the `Dockerfile` to match your environment.

