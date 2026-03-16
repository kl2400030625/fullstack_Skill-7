# Course App

Spring Boot CRUD application for managing courses using Spring Web, Spring Data JPA, and MySQL.

## Dependencies

- Spring Web
- Spring Data JPA
- MySQL Driver
- Lombok

## Project Structure

```text
src/main/java/com/example/courseapp
├── CourseappApplication.java
├── controller
│   └── CourseController.java
├── entity
│   └── Course.java
├── repository
│   └── CourseRepository.java
└── service
    └── CourseService.java
```

## Database Configuration

Update `src/main/resources/application.properties` if your MySQL username, password, or database name are different.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/university
spring.datasource.username=root
spring.datasource.password=root
```

Make sure the `university` database exists before starting the application.

## Run

If Maven is on your `PATH`:

```powershell
mvn spring-boot:run
```

If Maven is not on your `PATH`, use the local Maven installation path you already have:

```powershell
& "C:\Users\saibh\OneDrive\Pictures\Desktop\KLU\2-2\fullstack\apache-maven-3.9.12-bin\apache-maven-3.9.12\bin\mvn.cmd" spring-boot:run
```

## API Endpoints

### Add Course

`POST http://localhost:8080/courses`

```json
{
  "courseId": 101,
  "title": "Java Programming",
  "duration": "3 Months",
  "fee": 15000
}
```

### Get All Courses

`GET http://localhost:8080/courses`

### Get Course By ID

`GET http://localhost:8080/courses/101`

### Update Course

`PUT http://localhost:8080/courses/101`

```json
{
  "title": "Advanced Java",
  "duration": "4 Months",
  "fee": 20000
}
```

### Delete Course

`DELETE http://localhost:8080/courses/101`

### Search Course

`GET http://localhost:8080/courses/search/java`# fullstack_Skill-7
