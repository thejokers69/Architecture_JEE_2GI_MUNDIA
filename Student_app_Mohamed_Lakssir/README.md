# Student_app_Mohamed_Lakssir

This project is a Spring Boot application created for managing a simple product database using JPA, Hibernate, and Spring Data. It supports basic CRUD operations and demonstrates the use of H2 and MySQL databases for persistence. The project is structured to fulfill the requirements of an assignment on ORM, JPA, and Spring Data.

## Features

- Spring Boot application for managing products
- CRUD operations on Product entities
- Initial H2 database setup with optional migration to MySQL
- Example code structure and controller setup
- Lombok for simplifying Java code

## Project Requirements

1. **Create a Spring Boot project** using Spring Initializer with dependencies:
    - Spring Data JPA
    - H2 Database
    - Spring Web
    - Lombok

2. **Define the Product Entity** with the following fields:
    - `id` (type: Long)
    - `name` (type: String)
    - `price` (type: double)
    - `quantity` (type: int)

3. **Configure Database Connection** in `application.properties`:
    - Set up H2 as the default database
    - Configure MySQL settings for optional migration

4. **Create JPA Repository** for handling CRUD operations.

5. **Implement CRUD Operations** in a `ProductController` to:
    - Add a product
    - List all products
    - View a single product
    - Update a product
    - Delete a product

6. **Migrate Database** from H2 to MySQL if needed.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (in-memory)
- MySQL (for migration)
- Lombok

## Getting Started

### Prerequisites

- **Java 17** or later
- **IntelliJ IDEA Ultimate** (recommended for Spring support)
- **Maven** for dependency management
- **MySQL** (optional, for database migration)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/Student_app_Mohamed_Lakssir.git
   cd Student_app_Mohamed_Lakssir

	2.	Open the project in IntelliJ IDEA.
	3.	Build the project to download dependencies.

Configuration

	1.	Database Configuration in src/main/resources/application.properties:
For H2 Database (default):

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update

For MySQL (optional migration):

spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


	2.	Run the Application:
	•	Open the main application class (usually StudentAppMohamedLakssirApplication.java)
	•	Run the main method
	3.	Access H2 Console (for H2 Database):
	•	URL: http://localhost:8080/h2-console
	•	JDBC URL: jdbc:h2:mem:testdb

API Endpoints

The following REST endpoints are available for managing products:
•	Create Product: POST /products
•	Get All Products: GET /products
•	Get Product by ID: GET /products/{id}
•	Update Product: PUT /products/{id}
•	Delete Product: DELETE /products/{id}

Example Usage

Use tools like Postman or curl to interact with the API:
1.	Add a Product:

curl -X POST -H "Content-Type: application/json" -d '{"name":"Product A", "price":100.0, "quantity":10}' http://localhost:8080/products


	2.	Get All Products:

curl -X GET http://localhost:8080/products


	3.	Update a Product:

curl -X PUT -H "Content-Type: application/json" -d '{"name":"Updated Product", "price":150.0, "quantity":15}' http://localhost:8080/products/{id}


	4.	Delete a Product:

curl -X DELETE http://localhost:8080/products/{id}



Additional Resources

Refer to the following videos for a detailed guide on similar examples and additional implementations:
•	Video 1
•	Video 2
•	Video 3

License

This project is for educational purposes.

Created by Mohamed Lakssir as part of the “Architecture JEE” course.
