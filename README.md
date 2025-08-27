chatbot-api
===========

### Chatbot backend

Prerequisites
-------------

- [Eclipse Temurin JDK 21](https://adoptium.net/temurin/releases/?version=21)
- [Maven 3.9.6](https://maven.apache.org/download.cgi)

Run project locally
-------------------

Be sure to copy `.env.example` to `.env` and update it with your local database connection parameters before running the
application.

### Build application and database schema populating it with test data with Flyway Maven plugin

```bash
mvn clean install
```

### Starting application with Spring Boot Maven plugin

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

- To try application endpoints, open http://localhost:8080/swagger-ui/index.html in your web browser.

- To view api documentation, open http://localhost:8080/v3/api-docs in your web browser.
