# Assignment 5 – Unit, Mocking, and Integration Testing
# Simran Kaur

## Project Overview
This project is part of SE333 Assignment 5.  
It focuses on practicing unit testing and mocking using JUnit 5 and Mockito.  
In Part 1, we wrote and organized tests for the **BarnesAndNoble** class to verify its functionality.

## Part 1 – BarnesAndNoble Testing
### Specification-Based Testing
- Verified that `getPriceForCart()` correctly calculates total price for valid orders.
- Confirmed that `BuyBookProcess` is called with the correct book and quantity.

### Structural-Based Testing
- Tested the branch where the requested quantity exceeds available stock.
- Ensured the total price and quantity adjustments match expected behavior.

## Part 2 – Continuous Integration Workflow
A **GitHub Actions** workflow was added to automatically run tests and static analysis on each push to `main`.

- Runs **Checkstyle** and **JUnit tests** with **JaCoCo** coverage.
- Uploads both reports as workflow artifacts.
- Workflow runs successfully on every push.

![Build Status](https://github.com/simrankaur333/Assignment5_Code/actions/workflows/SE333_CI.yml/badge.svg)

## Part 3 – Amazon Testing

### Unit Tests
- Tested `calculate()` using mocks for `ShoppingCart` and `PriceRule`.
- Verified `addToCart()` correctly calls `ShoppingCart.add()`.

### Integration Tests
- Used real `ShoppingCartAdaptor` and `Database`.
- Tested total price calculation with multiple items.
- Verified behavior for empty cart.


