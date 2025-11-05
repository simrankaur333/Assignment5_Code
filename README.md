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

