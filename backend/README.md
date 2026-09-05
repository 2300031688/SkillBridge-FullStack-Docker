# SkillBridge Backend

Spring Boot + Maven Wrapper + Spring Data JPA/Hibernate + MySQL + REST CRUD.

## Run on Windows
Open CMD in this backend folder and run:

    .\mvnw.cmd spring-boot:run

Do NOT use `mvn` unless Maven is installed and added to PATH.

## Database
MySQL must be running.

- database: skillbridge
- username: root
- password: password
- port: 3306

Hibernate creates/updates tables automatically with `spring.jpa.hibernate.ddl-auto=update`.
