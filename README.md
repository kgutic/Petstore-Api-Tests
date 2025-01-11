# Swagger Petstore API Tests


## Overview
This project demonstrates a Behavior-Driven Development (BDD) approach to testing the [Petstore API](https://petstore3.swagger.io/) using Java, Rest Assured, Cucumber, and SerenityBDD.

It showcases a comprehensive testing framework designed to:
- Validate the functionality of the Petstore Swagger API.
- Ensure compliance with the API's defined schema and business requirements.
- Facilitate collaboration between technical and non-technical stakeholders through BDD principles.

By utilizing generated DTOs from the Petstore OpenAPI specification, the framework ensures that test cases remain consistent with the API schema, enabling robust and reliable validations.

### Key Features
- BDD Workflow: Tests are written in Gherkin syntax, promoting clear communication between developers and business stakeholders. These feature files not only describe the expected system behavior but also serve as living documentation, ensuring that the test scenarios remain up-to-date and reflect the current business requirements.
- SerenityBDD Reports: Generates detailed, interactive test execution reports for better insights into test outcomes.
- OpenAPI Integration: Guarantees type-safe and schema-compliant test cases with generated DTOs.
## Getting Started
To run the tests and generate a Serenity test report:
- Clone the repository and make sure JDK and Git is installed on your machine
- Add necessary dependencies according to the pom.xml file
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
## Technologies used
- IDE: IntelliJ
- Coding Language: Java
- Test automation frameworks: Cucumber, SerenityBDD
- OpenAPI Generator to produce DTOs from the OpenAPI specification
- API testing library: REST Assured
- Build and project management tool: Maven
### Disclaimer
Please note that the tests in this repository are a work in progress and may be subject to frequent changes and updates. They are intended for showcase purposes and may not cover all (edge) cases of the Petstore API.