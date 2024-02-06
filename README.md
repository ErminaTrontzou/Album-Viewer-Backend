# Album Viewer Backend
This repository contains the backend for the Album Viewer Site, developed using the Spring Boot framework. 
The backend is responsible for managing data related to albums, artists, and categories, and provides a RESTful API for the frontend to consume.

## Project Parts
- [**Album Viewer**](https://github.com/ErminaTrontzou/Album-Viewer-Frontend/tree/main)
- [**Album Viewer Admin Panel**](https://github.com/ErminaTrontzou/Album-Viewer-Admin-Panel)
  
## Project Structure
The backend follows the standard Entity-Repository-Service-Controller pattern, which is a widely accepted architecture for building clean and maintainable applications. Each layer has a specific responsibility:

  - **Entity**: Defines the domain model objects and their relationships.
  - **Repository**: Provides CRUD operations for the entities.
  - **Service**: Contains business logic and calls the repositories to fetch or update data.
  - **Controller**: Handles HTTP requests and delegates processing to the services.

##Future Plan
  - **CRUD System**: Implement a complete system for creating, reading, updating, and deleting entries.
  - **Login System**: Introduce authentication to secure access to the admin panel.
  
## Technologies
  - **Spring Boot**: A powerful framework for building standalone, production-grade Spring-based applications.
  - **Spring Data JPA**: Simplifies database access by providing a repository abstraction layer.
  - **MySQL**: Connects the application to MySQL databases.
  - **Lombok**: Reduces boilerplate code such as getters, setters, and constructors.
  - **JUnit and Mockito**: Tools for writing unit and integration tests.
    
## Build Configuration
The **build.gradle** file configures the project to use Java 17 as the source compatibility level and includes dependencies for Spring Boot, JPA, MySQL connector, Lombok, and testing frameworks.

## Database Management
The backend uses **PHPMyAdmin** for database management, which allows for easy visualization and manipulation of the data stored in MySQL

## Setup
To set up the development environment and run the Album Viewer Site locally:
```
git clone https://github.com/ErminaTrontzou/Album-Viewer-Backend.git
cd Album-Viewer-Backend
./gradlew bootRun
```
Visit `http://localhost:8080/` in your web browser to interact with the backend.

## License
The Album Viewer Site is licensed under the [MIT license](LICENSE), promoting open-source collaboration and reuse.
