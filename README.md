# SkillBridge - Full Stack

React frontend + Spring Boot backend + Maven + Spring Data JPA/Hibernate + MySQL.

## Requirements
- JDK 17 or newer
- Node.js 18 or newer
- MySQL 8.x running on port 3306

You do NOT need Maven installed or added to PATH. `backend/mvnw.cmd` downloads and uses Maven automatically.

## Database
Create the database if it does not already exist:

CREATE DATABASE skillbridge;

Backend configuration:
- Username: root
- Password: password
- Database: skillbridge
- Port: 3306

## Run backend
Open Command Prompt in `backend` and run:

    mvnw.cmd spring-boot:run

Do not use `mvn spring-boot:run` unless Maven is separately installed and added to PATH.

## Run frontend
Open another Command Prompt in `frontend` and run:

    npm install
    npm run dev

Open the Vite URL shown in the terminal (normally http://localhost:5173).

## One-click options
From the project root:
- `START-BACKEND.cmd`
- `START-FRONTEND.cmd`
- `START-FULLSTACK.cmd`

## Backend structure
controller -> service -> repository -> model

JPA/Hibernate handles database mapping and persistence.
