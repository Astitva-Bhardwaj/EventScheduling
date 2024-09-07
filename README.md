# Event Scheduling Application

This project is an event scheduling application that allows users to log in, view their availability, and create sessions. Admin users can manage user availabilities, create sessions, and assign users to sessions.

## Features

- User login with Admin and Regular User roles
- Role-based redirection to Admin or User dashboards
- Admin users can view other users' availability and create new sessions
- Session creation with specific start times, durations, and user assignments
- Frontend built with Thymeleaf and styled with Tailwind CSS
- Backend developed using Spring Boot and MySQL database

## Technologies Used

- Java 11+
- Spring Boot
- Spring Data JPA (Hibernate)
- Thymeleaf
- Tailwind CSS
- MySQL
- Maven

## Prerequisites

Before running this project, ensure you have the following installed on your machine:

- [Java 11+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven 3.6+](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/mysql/)

## Getting Started

### Step 1: Clone the Repository

First, clone this repository to your local machine:

```bash
git clone https://github.com/your-username/event-scheduling-app.git
cd event-scheduling-app


### Step 2: Configure the MySQL Database
Install and start MySQL on your system.
Create a database named event_scheduler. You can do this by logging into MySQL and running:
CREATE DATABASE event_scheduler;

Step 3: Build the Project
Use Maven to build the project and resolve dependencies:
mvn clean install

Step 4: Run the Application
After the project is built successfully, you can run the Spring Boot application using the following command:
mvn spring-boot:run

Step 5: Access the Application
Login page: http://localhost:8080/users/login
Admin users will be redirected to the admin dashboard.
Regular users will be redirected to the user dashboard.
Admin Dashboard: http://localhost:8080/admin_dashboard?email={email}
User Dashboard: http://localhost:8080/users_dashboard?email={email}
