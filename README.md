# SauceDemo Automation Framework

A comprehensive test automation framework using Selenium WebDriver, Cucumber, TestNG, and REST Assured.

## Features

- **BDD Approach**: Cucumber with Gherkin syntax
- **Cross-Browser Testing**: Chrome and Firefox support
- **Parallel Execution**: TestNG configured for parallel runs
- **Page Object Model**: Maintainable and scalable structure
- **API Testing**: REST Assured integration
- **Allure Reports**: Detailed test reporting

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Chrome and Firefox browsers

## Installation

1. Extract the project files
2. Open terminal/command prompt in the project directory
3. Install dependencies: `mvn clean install`

## Configuration

Edit `src/test/resources/config.properties`:

```properties
browser=chrome
base.url=https://www.saucedemo.com/
api.base.url=https://simple-books-api.glitch.me
