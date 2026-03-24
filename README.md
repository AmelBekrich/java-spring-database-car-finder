# Car filtering application

Spring Boot Web application that allows users to browse cars based on brand, production year
and fuel type.
Users can also add new cars to the database.

The application now also exposes a REST API.

## Features

  - Filter cars by brand
  - Filter cars by model
  - Filter cars by production year
  - Filter cars by fuel type
  - Load cars from a database
  - Add new cars to the database
  - Display results in a table on a web page
  - Display the current number of loaded cars in the table
  - Sorting cars by price, year, consumption
  - Get car data and add new cars via REST API
  - Frontend using React

## Technologies 

  - Java
  - Spring Boot
  - Spring Boot JPA
  - SQL
  - Thymeleaf
  - Java Streams
  - REST API with Spring Boot

## How to run
    
    - Web frontend
        - Run App.java
        - In a browser, go to localhost:8080/cars

    - REST API
        - GET cars: http://localhost:8080/api/cars
