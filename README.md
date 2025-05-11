# Microservices-Based Spring Boot Application
This repository contains a complete microservices-based system built with **Spring Boot**, including service discovery, configuration management, API gateway, fault tolerance (Resilience4j), and rate limiting. It demonstrates a production-ready microservices architecture following best practices.

# Project Structure
├── EventService/ # Handles events

├── Gateway/ # API Gateway with routing

├── RatingService/ # Handles user ratings for events

├── ServiceRegistry/ # Eureka service discovery server

├── UserService/ # Manages users

├── configServer/ # Centralized configuration server

├── application.properties # Base Spring Boot configuration

├── application-dev.properties

├── application-prod.properties

# Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Cloud** (Eureka, Config Server, Gateway)
- **MySQL**
- **Resilience4j** (Circuit Breaker, Retry, Rate Limiter)
- **Spring Actuator**
- **Lombok**
- **Maven**
- **Git**

  
# How to Run

**Step 1:** Clone the repository  
  > git clone https://github.com/Maniteja03/microservices-config.git

**Step 2:** Start MySQL
  >Add your MySQL credentials in the application.properties file

    - spring.datasource.username=your_mysql_username
    
    - spring.datasource.password=your_mysql_password

**Step 3:** Start the services in this order (via IDE or terminal):
  -configServer
  
  -ServiceRegistry
  
  -Gateway
  
  -UserService, EventService, RatingService
 

