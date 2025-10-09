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

## Tech Stack

- Java 17 - Programming Language
- Spring Boot 3.5.6 - Application framework.
- Spring Web - Module for building RESTful APIs.
- RestTemplate - Client for consuming external REST APIs.
- SerpAPI - External API for Google Scholar data.
- Spring Dotenv - Loads environment variables from .env files.
- Maven - Build and dependency management tool.

## Prerequisites

- Java 17 or higher installed
- Maven 3.6 or higher installed
- SerpAPI account

## Installation & Setup

### CLone the repository

```bash
git clone https://github.com/alomeliBravo/challenge_3_techno_ready.git
cd googleschoolarapi
```

### Configure Environment variables

First create an enviroment file based on .env.example file

```bash
cp .env.example .env
```

### Build the project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

### Test Application

```bash
Use GET "localhost:8080/author/{id}"
```