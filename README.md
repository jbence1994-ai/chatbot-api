chatbot-api
===========

### Chatbot backend

[![Continuous Integration](https://github.com/jbence1994-ai/chatbot-api/actions/workflows/build.yaml/badge.svg)](https://github.com/jbence1994-ai/chatbot-api/actions/workflows/build.yaml)

Prerequisites
-------------

- [Eclipse Temurin JDK 21](https://adoptium.net/temurin/releases/?version=21)
- [Maven 3.9.6](https://maven.apache.org/download.cgi)
- [Ollama](https://ollama.com)

Run project locally
-------------------

- Start Ollama with your favored large language model (text-ot-text)
- Be sure to copy `.env.example` to `.env` and update it with the LLM parameters before running the application

### Build application

```bash
mvn clean install
```

### Starting application with Spring Boot Maven plugin

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=default
```

- To try the application endpoint, send a POST request to `http://localhost:8080/api/chat` with a REST client (Postman,
  Insomnia, Bruno, etc.) with the following request body:

```json
{
  "prompt": "<string>",
  "conversationId": "<uuid>"
}
```
