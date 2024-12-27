# Digital Banking Project

A simple **Spring Boot** application demonstrating how to manage bank accounts (current and saving), customers, and account operations (credit/debit). This project showcases a basic architecture for a JEE application using **Spring Boot**, **Spring Data JPA**, and **H2** in-memory database.

## Table of Contents
- [Project Tree](#project-tree)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Key Entities and Repositories](#key-entities-and-repositories)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Future Improvements](#future-improvements)

---

## Project Tree

```bash
.
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── ma
│   │   │       └── mundiapolis
│   │   │           └── digital_banking
│   │   │               ├── DigitalBankingApplication.java
│   │   │               ├── entities
│   │   │               │   ├── AccountOperation.java
│   │   │               │   ├── BankAccount.java
│   │   │               │   ├── CurrentAccount.java
│   │   │               │   ├── Customer.java
│   │   │               │   └── SavingAccount.java
│   │   │               ├── enums
│   │   │               │   ├── AccountStatus.java
│   │   │               │   └── OperationType.java
│   │   │               └── repositories
│   │   │                   ├── AccountOperationRepository.java
│   │   │                   ├── BankAccountRepository.java
│   │   │                   └── CustomerRepository.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── ma
│               └── mundiapolis
│                   └── digital_banking
│                       └── DigitalBankingApplicationTests.java
└── target
    └── ... (generated files and folders)
```

---

## Technologies Used

- **Java 17**
- **Spring Boot 3** (Web, Data JPA, Security)
- **Maven**
- **H2 Database** (in-memory database for testing)
- **Lombok** (optional, for boilerplate reduction)

---

## Getting Started

1. **Clone or Download** this repository.
2. Make sure you have **Java 17** (or later) and **Maven** installed on your system.
3. (Optional) If using Lombok, ensure you have enabled annotation processing in your IDE.

---

## Project Structure

- **`DigitalBankingApplication.java`**: Main class to bootstrap Spring Boot.
- **`entities`**: Holds JPA entities such as `Customer`, `BankAccount` (abstract), `CurrentAccount`, `SavingAccount`, and `AccountOperation`.
- **`enums`**: Holds enumeration classes like `OperationType` (DEBIT, CREDIT) or `AccountStatus`.
- **`repositories`**: Spring Data JPA repositories that provide CRUD operations on the entities.
- **`application.properties`**: Spring Boot configuration file (H2 database settings, server port, etc.).

---

## Key Entities and Repositories

1. **Entities**:
    - **`Customer`**: Represents a bank customer (with an ID, name, email, etc.).
    - **`BankAccount`** (abstract): Parent class for `CurrentAccount` and `SavingAccount`.
    - **`CurrentAccount`**: Inherits from `BankAccount` and adds an `overdraft` property.
    - **`SavingAccount`**: Inherits from `BankAccount` and includes an `interestRate`.
    - **`AccountOperation`**: Represents a transaction on an account, specifying the operation date, amount, and operation type (DEBIT or CREDIT).

2. **Repositories**:
    - **`CustomerRepository`**: Manages `Customer` CRUD operations.
    - **`BankAccountRepository`**: Manages both `CurrentAccount` and `SavingAccount`.
    - **`AccountOperationRepository`**: Manages operations linked to accounts.

---

## Running the Application

1. **Configure**:
    - Check `application.properties` for the default H2 configuration and server port. Usually, it’s `spring.h2.console.enabled=true` and `spring.datasource.url=jdbc:h2:mem:testdb`.

2. **Build & Run**:
   ```bash
   # From the project root directory
   mvn clean install
   mvn spring-boot:run
   ```
    - Alternatively, use the Maven wrapper `./mvnw spring-boot:run`.

3. **H2 Console** (if enabled):
    - Open your browser and go to `http://localhost:8080/h2-console`.
    - The default JDBC URL is `jdbc:h2:mem:testdb`.

You should see tables like `CUSTOMER`, `BANK_ACCOUNT`, `ACCOUNT_OPERATION`, etc., once the application is up and running.

---

## Testing

- **Unit Tests**:
    - A basic test class is located under `src/test/java/ma/mundiapolis/digital_banking/DigitalBankingApplicationTests.java`.
    - You can add more tests to cover repositories and service logic.

- **Manual Testing**:
    - Since we have no controllers yet (if you haven’t added them), you can verify data in the H2 console.
    - If you add REST controllers, use tools like **Postman** or **cURL** to test your endpoints.

---

## Future Improvements

- **REST Controllers**: Expose CRUD endpoints for Customers, Bank Accounts, and Account Operations.
- **Service Layer**: Add a service layer (e.g., `BankAccountService`) to encapsulate business logic (deposit, withdraw, transfer).
- **Security**: Integrate **Spring Security** and **JWT** for authentication/authorization.
- **Swagger**: Use `springdoc-openapi` dependency for auto-generated API documentation at `/swagger-ui.html`.
- **Angular Frontend**: Create an Angular client to consume the REST endpoints, display accounts, operations, etc.

---

> **Author**: **Mohamed Lakssir 2ACI Info**
> **Date**: 13 December 2024

Feel free to reach out if you have any questions or suggestions!

