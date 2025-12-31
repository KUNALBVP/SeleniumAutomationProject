# 🛒 Selenium Automation Framework – E-Commerce Website

## 📌 Project Overview
This project is a Selenium-based test automation framework developed in Java to automate an E-commerce web application. The framework focuses on validating functional and end-to-end user flows across the application. It is structured to ensure clear separation of test logic and UI interactions. The project supports scalable automation with clean and readable test code. Source code is maintained using GitHub for version control.

## 🧱 Framework Design & Approach
The framework is designed using the Page Object Model (POM), which separates UI elements from test logic. Each web page has its own page class containing web element locators and reusable methods. Separate test classes validate application workflows by interacting with page methods. Common Selenium operations are centralized in a separate class to ensure reusable and consistent test actions across the framework.

## 🧪 Testing Strategy & Execution
Test execution is managed using TestNG for handling test lifecycle and assertions. Test cases are organized into Smoke, Sanity, and Regression suites for selective execution. Data Driven Testing is implemented to execute test cases with multiple data sets. The framework supports cross-browser testing and parallel execution using TestNG configuration.

## 🛠 Tech Stack & Tools
- **Programming Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Design Pattern:** Page Object Model (POM)  
- **Version Control:** Git & GitHub  
- **Data Driven Testing:** TestNG DataProvider / External test data  
- **Browser Support:** Chrome, Firefox, Edge
