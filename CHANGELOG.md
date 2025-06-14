# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project (tries) to adhere to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.2] - 2025-06-14

### Added

- Added missing reference in `CHANGELOG` to tag [1.0.1].
- Added **Contributors** section to `README` using [contrib.rocks](https://contrib.rocks).
- Added referenced materials to `README` under **Used documentation / referenced help**.

## [1.0.1] - 2025-06-13

### Fixed

- Change `FloodDAO` and `RainfallDAO` identifiers to be of type `Year` to match database.
- Change table name reference in `Flood` and `Rainfall` models to be non-capitalized, database changed accordingly.

## [1.0.0] - 2025-06-12

### Added

- Added `YearConverter` to convert the database column of type `year` to a valid Java instance of type `Year` and vice versa.
- Added `Flood` and `Rainfall` model entities with validated columns and width obligatory getters and setters.
- Added `FloodDAO` and `RainfallDAO` for CRUD operations.

### Updated

- Updated `README` with sections:
  - **Project Overview**: A brief overview of the framework used.
  - **Getting Started**:
    - **Dependencies**: List of dependencies used.
   	- **Setup**: Detailed instructions on downloading, installing and building the project for local use.
   	- **Notes**: Additional notes regarding setup instructions.
  - **Usage**: Instructions on where to access the application in the browser.
  - **Used Documentation / Referenced Help**: Resources referenced during development.
  - **Licenses**: Licensing information.
- Updated `APIController` to handle GET requests for `""` and `"/"` for testing purposes, and `"/data-raw/all"` for retrieving all rainfall data from the database.
- Updated `WebController` to handle GET requests for `"/data-raw/{year}"` (to retrieve rainfall data far a specific year) and `"/data-raw/all"` (to retrieve all rainfall data from the database).
- Updated `data-raw.html` to use Thymeleaf templating for displaying rainfall table information.

## [0.2.0] - 2025-06-12

### Updated

- Updated `colors.css` with a comprehensive, but incomplete, color palette for light and dark themes.
- Updated `font.css` by adding a default font size.
- Updated `style.css` with new styles for `main`, `footer`, `h3`, `button`, and `table` elements.
- Updated `index.html` to include a table temporarily displaying an example of seasonal rainfall and flood risk data.
- Updated `layout.html` to include a logo in the navigation and footer sections.
- Updated `.gitignore` to exclude `.markdownlint.json`, `cspell.json`, and `.cspell` directory.
- Versioning correction for previous changelog entry. Adjusted tag accordingly.

## [0.1.0] - 2025-06-11

### Added

- Added `APIController.java` and `WebController.java` for handling API and web requests respectively.
- Added `.css` files for styling (`animations.css`, `colors.css`, `font.css`, `queries.css`, and `style.css`).
- Added `init.js` for dynamic HTML page interactions.
- Added HTML templates for the web page content using Thymeleaf (`data-raw.html`, `index.html`, and `layout.html`).

## [0.0.1] - 2025-06-11

### Added

- Added a datasource in [application.properties](src/main/resources/application.properties).

## [0.0.0] - 2025-06-11

### Added

- Initial project structure based on assignment requirements.
- [README](README.md) with project title.
- [CHANGELOG](CHANGELOG.md) for documenting changes.
- Maven configuration ([POM](pom.xml)) for a Spring Boot project.
- [Git Ignore](.gitignore) and [Git Attributes](.gitattributes) for repository management.
- [MIT license](LICENSE)

[1.0.2]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v1.0.2
[1.0.1]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v1.0.0
[1.0.0]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v1.0.0
[0.2.0]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v0.2.0
[0.1.0]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v0.1.0
[0.0.1]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v0.0.1
[0.0.0]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v0.0.0
