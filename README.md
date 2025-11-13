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

2) Build the Docker image (from repository root)

```powershell
docker build -t student-management-app .
```

3) Run the container

```powershell
docker run -p 8080:8080 student-management-app
```

4) Optional: Use docker-compose with a MySQL service (provided in `docker-compose.yml`)

```powershell
docker-compose up --build
```

Notes:
- Update the jar name in `Dockerfile` if your artifactId/version differs (`studentmanagement-0.0.1-SNAPSHOT.jar`).
- The `docker-compose.yml` in the repo starts a MySQL 8.0 container and the app, and maps ports 3306 and 8080.
- Use `.dockerignore` (included) to keep your build context small.

Tip: This repository now includes a multi-stage `Dockerfile` which builds the application inside a Maven image and produces a smaller runtime image. You don't need to run `mvn package` locally; `docker build` will compile the project during the image build.

Example multi-stage build commands (from repository root):

```powershell
# build image (this will run mvn package inside the build stage)
docker build -t student-management-app .

# run
docker run -p 8080:8080 student-management-app
```


---

### 2. Get All Students

GET /api/v1/students

---

### 3. Get Student by ID

GET /api/v1/students/{id}

---

### 4. Update Student

PUT /api/v1/students/{id}

Request Body:

```json
{
  "name": "mathi Updated",
  "email": "mathiupdated@example.com",
  "course": "Software Engineering",
  "age": 22
}
```

---

### 5. Delete Student

DELETE /api/v1/students/{id}

---

## Validation Rules

Field    | Rule
-------- | ------------------------
name     | must not be blank
email    | must be valid & unique
course   | must not be blank
age      | must be ≥ 19

---

## Global Exception Handling

The application provides centralized error responses for common failures.

Handled exceptions:
- ResourceNotFoundException → 404 Not Found
- MethodArgumentNotValidException → 400 Bad Request
- Exception → 500 Internal Server Error

All error responses include the following fields:
- timestamp — ISO-8601 timestamp of the error
- status — HTTP status code
- error/message — short error message
- errors — list or map of field validation errors (if any)

Example error response (validation):

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



✅ How to Test
Use Postman to send API requests to the endpoints above.

Verify responses and database records in db_student_api.


👨‍💻 Author
Name: Mathivarman
Index Number: ICT21887
Course: BICT (Hons) – University of Sri Jayewardenepura
Subject: ITS 4243 – Microservices and Cloud Computing

---

✅ This version includes:
- Short project description  
- Technologies  
- Database setup  
- Step-by-step guide to run  
- API endpoints table  
- Example POST request  

---

