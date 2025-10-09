# Challenge 3: Server and Database Commands

## Project purpose:

Automate the integrations of informations for the institution's Top 3 researchers, eliminating manual processes and ensuring data flows efficiently into the research database from serpAPI.

## Key functionalities:

- Extract researcher informations trough the Google Scholar API (SerpAPI).
- Map and structure JSON data to align with the database format
- Store and manage researcher information in memory using Java
- Populate the research database automatically with the processed data.
- Maintain documentation and version control in GitHub throughout development

## Project relevance:

It replaces time-consuming and error-prone manual integration with and automated solution, streamlining research data management. This improves efficiency, accuracy, and accesibility of researcher information for intitutional procesess.

## Technologies used

- Java 17 - Programming Language
- Spring Boot 3.5.6 - Application Framework
- RestTemplate - HTTP Client to implement SerpAPI
- Spring Web - Provide support for building RESTful APIs
- SerpAPI - External API from Google Scholar
- Spring Dotenv - Library for loading environment variables
- Maven - Build automation adn dependency management.

## Prerequisites

- Java 17 or higher installed
- Maven 3.6 or higher installed
- SerpAPI account

## Instalation and execution

### Clone the repository

```bash
git clone https://github.com/alomeliBravo/challenge_3_techno_ready.git
cd googleschoolarapi
```

### Configure environment variables

Create and environment file based on the .env.example

```bash
cp .env.example .env
```

And insert your serpAPI Key.

### Execute the application

```bash
mvn spring-boot:run
```