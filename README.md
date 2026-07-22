# Employee Management System (JDBC)

A Java Console-Based Employee Management System developed using **Core Java, JDBC, and MySQL**.  
This project performs CRUD (Create, Read, Update, Delete) operations on employee records and follows a layered architecture using DAO and Service classes.

---

## Features

- Add Employee
- View Employees
- Update Employee
- Delete Employee
- Search Employee by ID
- Input Validation
- Custom Exception Handling
- DAO Layer
- Service Layer
- Try-With-Resources
- MySQL Database Integration

---

## Technologies Used

- Java
- JDBC
- MySQL
- IntelliJ IDEA
- Git
- GitHub

---

## Project Structure

```
src
│
├── dao
│      EmployeeDAO.java
│
├── service
│      EmployeeService.java
│
├── model
│      Employee.java
│
├── util
│      DatabaseConnection.java
│
├── exception
│      InvalidEmployeeException.java
│
└── Main.java
```

---

## Database Schema

**Table Name:** employee

| Column | Data Type |
|---------|-----------|
| id | INT (Primary Key) |
| name | VARCHAR(100) |
| salary | DOUBLE |

---

## How to Run

1. Clone this repository.

```
git clone <repository-url>
```

2. Open the project in IntelliJ IDEA.

3. Create the MySQL database.

```sql
CREATE DATABASE employee_db;
```

4. Create the employee table.

```sql
CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    salary DOUBLE
);
```

5. Update your database credentials inside:

```
DatabaseConnection.java
```

6. Run:

```
Main.java
```

---

## Project Workflow

```
User

↓

Main.java

↓

EmployeeService

↓

EmployeeDAO

↓

MySQL Database
```

---

## Sample Menu

```
===== Employee Management System =====

1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Search Employee
6. Exit
```

---

## Concepts Implemented

- Object-Oriented Programming (OOP)
- JDBC
- PreparedStatement
- ResultSet
- CRUD Operations
- Exception Handling
- Custom Exceptions
- Layered Architecture
- Try-With-Resources
- Git & GitHub

---

## Future Improvements

- Convert Console Application to Spring Boot
- Browser-Based User Interface
- Spring Data JPA
- Hibernate
- REST APIs
- Login Authentication
- Pagination
- Search Filters
- Bootstrap UI

---

## Author

**Pooja Kumawat**

Aspiring Java Backend Developer

GitHub:
https://github.com/kumawatpooja9541-svg

---
