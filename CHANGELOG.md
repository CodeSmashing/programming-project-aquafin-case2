# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project (tries) to adhere to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased] - 2025-06-18

### Updated

- Replaced tag references for commits related to the branch `data-overview-user` with a `Unreleased` tag.
- Refactored `colors.css` to:
  - Expand the color palette and fix light/dark theme support.
  - Use `background-color` instead of `background` for background colors.
  - Include commonly used colors used so far throughout the CSS.
  - Group related styling together (nav element specific styling is brought under `nav`, input and it's variation under `input`, ...).
  - Remove extra nav bar related classes.
- Enhanced `font.css` by removing anchor decorations.
- Improved `style.css` by:
  - Removing unused import for `./test.css`.
  - Removing font related styling (text-alignment excluded).
  - Moving box shadow styling to `colors.css`
  - Group related styling together (nav element specific styling is brought under `nav`, input and it's variation under `input`, ...).
  - Removing extra nav bar related classes.
- Updated `data-raw.html` and `index.html` to include dynamic chart rendering using Chart.js and updated table styling.
- Updated `layout.html` to include a new logo and reverted navigation structure to before the extra nav classes.
- Added `Logo_Aquafin.png` to the project for branding purposes.

### Fixed

- Corrected inconsistencies in CSS variables, their uses and hover effects for better user experience.

## [Unreleased] - 2025-06-17

### Updated

- Refactored `colors.css` to include additional color variables for improved styling consistency and accessibility.
- Enhanced `style.css` with new styles for `form`, `table`, `button`, and `navbar` elements, including hover effects and disabled states.
- Simplified `index.html` structure by replacing static table data with dynamic Thymeleaf expressions for rendering seasonal rainfall and flood risk data.
- Added a filter form and chart section to `index.html` for better user interaction and data visualization.
- Updated `layout.html` to improve navigation bar styling and structure, including the addition of a logo and responsive design adjustments.

## [1.2.0] - 2025-06-18

### Updated

- Refactored `FloodDAO` and `SeasonDAO` to use `Integer` as the identifier type instead of `Year` for better compatibility with the database schema.
- Updated `Flood` model to replace `Year` type with `Integer` for the `year` field and removed the `YearConverter`.
- Modified `Month` model to reference `Flood` (`floodId`) instead of `Season` (`seasonId`) for improved alignment with the database schema.
- Updated `Season` model to clarify the relationship with `Flood` (`floodId`) and adjusted annotations for consistency.

### Fixed

- Corrected column mappings and validation annotations in `Flood`, `Month`, and `Season` models to ensure proper database integration.

## [1.1.2] - 2025-06-17

### Added

- Added `lastUpdated` column mapping to `Flood`, `Season`, and `Month` models for tracking the last modification timestamp.
- Updated `Month` model to reference `Season` instead of `Flood` for better alignment with the database schema.
- Updated `Season` model to reference `Flood` instead of individual months for improved structure and consistency.
- Removed redundant `Rainfall` model and its associated mappings.
- Updated `MonthDAO` and `SeasonDAO` to reflect changes in model relationships.

### Updated

- Refactored `Flood` model to remove direct references to seasons (`winter`, `spring`, `summer`, `fall`) and simplify its structure.
- Adjusted table names in `Month` and `Season` models to match the database schema (`overstromingsgevaren_maanden` and `overstromingsgevaren_seizoenen`).
- Improved validation annotations and column mappings in `Month` and `Season` models for better data integrity.

## [1.1.1] - 2025-06-17

### Removed

- Removed `Rainfall` model.

## [1.1.0] - 2025-06-17

### Added

- Added `Month` and `Season` models to represent monthly and seasonal rainfall data.
- Added `MonthDAO` and `SeasonDAO` for CRUD operations on `Month` and `Season` entities.
- Updated `Flood` model to include relationships with `Season` entities (`winter`, `spring`, `summer`, `fall`).
- Updated `APIController` and `WebController` to use `MonthDAO` and `SeasonDAO` for rainfall data retrieval.
- Added Thymeleaf `@ModelAttribute` method in `WebController`, attribute being `rainfallList` to provide seasonal rainfall data to templates.

### Updated

- Renamed `RainfallDAO` to `SeasonDAO` to better reflect its purpose.
- Updated `FloodDAO` and `SeasonDAO` to handle relationships between `Flood`, `Season`, and `Month` entities.

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

<!-- [Unreleased]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v -->
[1.2.0]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v1.2.0
[1.1.2]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v1.1.2
[1.1.1]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v1.1.1
[1.1.0]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v1.1.0
[1.0.2]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v1.0.2
[1.0.1]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v1.0.0
[1.0.0]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v1.0.0
[0.2.0]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v0.2.0
[0.1.0]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v0.1.0
[0.0.1]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v0.0.1
[0.0.0]: https://github.com/CodeSmashing/programming-project-aquafin-case2/releases/tag/v0.0.0
