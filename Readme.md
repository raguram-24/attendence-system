# Attendance System

This project is a Spring Boot application that uses PostgreSQL as its database for managing attendance data.

## Prerequisites

Before you begin, ensure you have the following installed:

- [PostgreSQL](https://www.postgresql.org/download/)
- Java 21 or later
- Maven

## Setup Instructions

Follow these steps to set up and run the project:

### Step 1: Install PostgreSQL and pgAdmin 4

1. Download PostgreSQL from the [official site](https://www.postgresql.org/download/).
2. During installation, set a superuser username and password.
3. Install pgAdmin 4 to manage your databases.

### Step 2: Create the Database

1. Open pgAdmin 4 and log in with your PostgreSQL credentials.
2. Right-click on "Databases" in the Object Browser and select **Create > Database**.
3. Name the database `attendenceSystem` and assign the PostgreSQL username as the owner.

### Step 3: Update Configuration

1. Open the project file `application.properties` located in `src/main/resources`.
2. Add the following configuration:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/attendenceSystem
   spring.datasource.username=<your_postgres_username>
   spring.datasource.password=<your_postgres_password>
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

### Step 4: Run the Application

1. Open the terminal and navigate to the project directory.
2. Use Maven to install dependencies and run the project:

   ```
   mvn install
   mvn spring-boot:run
   ```

### Step 5: Frontend Setup

1. Install the project dependencies using npm:

   ```
   npm install
   ```
2. Start the development server:

   ```
   npm run dev
   ```
3. This will launch the frontend on a local server, typically at `http://localhost:5173/`
