# Petstore API Tests


## Overview
This repository contains automated tests for the [Petstore API](https://petstore.swagger.io/). The tests are written in Java using Cucumber and the Serenity BDD framework. 
The tests cover a few basic operations like creating, retrieving, and deleting pets, along with validating the responses and ensuring data integrity.
## Getting Started
To explore the tests and generate a Serenity test report:
- First clone the repository and make sure Maven and JDK is installed on your machine
- Run the following command in the project
`./mvnw clean verify`
- The console output will include the lines
```
[INFO] SERENITY REPORTS
[INFO]   - Full Report: file:///Users/<your-user>/<path-to-repo>/PetstoreApiTests/target/site/serenity/index.html
```
If you click on the link you should see the Serenity report.
Serenity BDD provides rich HTML reports after test execution. These reports contain detailed information about each scenario, including steps, failures, screenshots, and logs.
For more info visit [SerenityBDD](https://serenity-bdd.github.io/).
## Technologies
- Java
- OpenAPI
- Cucumber
- Rest Assured
- SerenityBDD

### Disclaimer
Please note that the tests in this repository are a work in progress and may be subject to frequent changes and updates. They are intended for showcase purposes and may not cover all (edge) cases of the Petstore API.