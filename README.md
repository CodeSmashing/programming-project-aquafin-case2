# Programming Project Aquafin case 2

Final project for the subject Programming Project.
This project is meant as a web application made based on our final assignments given for a company called [Aquafin](https://www.aquafin.be/nl-be/particulieren).

___

## Project Overview

This repository contains the project for case 2 for Programming Project.
It is built using the [Spring Boot](https://spring.io/projects/spring-boot) framework and tries to follow best practices.

___

## Getting Started

### Dependencies

- **spring-boot-starter-data-jpa**
- **spring-boot-starter-thymeleaf**
- **spring-boot-starter-web**
- **jakarta.validation-api (v3.1.1)**
- **mysql-connector-j**
- **spring-boot-starter-test**
- **junit-jupiter (v5.10.2)**

___

### Setup

1. **Download and Extract the Project**
   - Download the `.zip` file containing the project.
   - Extract the contents to your desired directory.

2. **Install Java and Maven**
   - Ensure you have **Java 17** (or the version specified in the `pom.xml`) installed.
   - Install **Maven** (or use the included Maven Wrapper `mvnw`/`mvnw.cmd`).

3. **Configure the Database**
   - Update the database connection details in `src/main/resources/application.properties`:

	```properties
	spring.datasource.url=jdbc:mysql://<your-database-host>:<port>/<database-name>
	spring.datasource.username=<your-username>
	spring.datasource.password=<your-password>
	```

4. **Build the Project**
   - Open a terminal in the project directory.
   - Run the following command to build the project:

     ```bash
     ./mvnw clean install
     ```

     *(Use `mvnw.cmd` on Windows.)*

5. **Run the Application**
   - Start the application using:

     ```bash
     ./mvnw spring-boot:run
     ```

     *(Use `mvnw.cmd` on Windows.)*

6. **Access the Application**
   - Open your browser and navigate to [localhost:8080](http://localhost:8080) (or as otherwise detailed in the `application.properties` file).

___

### Notes

- Ensure MySQL is running and the database is created before starting the application.
- If you encounter issues, check the logs for errors and verify your `application.properties` configuration.

___

## Usage

- Access the application at [localhost:8080](http://localhost:8080) after running the application.
- API endpoints are available under `/api`.

___

## Contributors

<a href="https://github.com/CodeSmashing/programming-project-aquafin-case2/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=CodeSmashing/programming-project-aquafin-case2" />
</a>

___

## Used documentation / referenced help

- [Year convertor](https://github.com/joschaBurkholz/jpa-attribute-converter/blob/master/src/main/java/de/joschaburkholz/jpaattributeconverter/YearConverter.java).
- [Example bar charts](https://www.pinterest.com/pin/458733912049295230/).
- [Example bar charts](https://www.pinterest.com/pin/49680402135788243/).
- [Contributors (using contrib.rocks)](https://contrib.rocks).
- [JPA Query's](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html).
- [W3School (Java)](https://www.w3schools.com/java/).
- [Dynamic module loading](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Modules#dynamic_module_loading).
- [Get full month names](https://stackoverflow.com/questions/51843760/how-can-i-change-the-language-of-the-months-provided-by-localdate).
- [Java docs Month LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/Month.html).
- [Using LocalDate](https://dev.java/learn/date-time/dayofweek-month/).

___

## Licenses

This project is open-source and available under the [MIT license](LICENSE).
