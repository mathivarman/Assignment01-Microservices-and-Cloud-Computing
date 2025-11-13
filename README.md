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

🧪 Example Request (POST)
json
{
  "name": "Mathivarman",
  "email": "mathivarman24mv@gmail.com",
  "course": "BICT",
  "age": 24
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





