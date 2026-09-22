# Arkansas State Park Reservation Engine

## Overview

This project tests an Arkansas State Park reservation price calculator using **Java, Maven, and JUnit 5**.

The tests use:

* Boundary Value Analysis (BVA)
* Equivalence Partitioning (EP)
* Decision Tables

The test suite contains **13 test cases**.

## Requirements

Install the following:

* **JDK 17 or later**
* **Apache Maven**
* **Git**

Check that Java and Maven are installed:

```bash
java -version
mvn -version
```

## Installation

### 1. Clone the repository

Open a terminal and run:

```bash
git clone https://github.com/polarmilk/software-testing-lab3
```

### 2. Open the project

Open the downloaded project folder in IntelliJ IDEA or another Java IDE.

Make sure the project contains `pom.xml`.

Maven will use `pom.xml` to download the required JUnit dependencies.

## Run the Tests

Open a terminal in the project folder and run:

```bash
mvn test
```

This will compile the project and run all JUnit tests.

A successful run should show:

```text
BUILD SUCCESS
```

All **13 tests** should pass.

## Alternative: Run Through IntelliJ IDEA

If using IntelliJ IDEA or another IDE with built-in Maven and JUnit support, the tests can be run directly from the IDE instead of using the terminal.

1. Open the project in the IDE.
2. Open:
   `src/test/java/com/baarsch_bytes/UnitTesting/ReserveMyParkTest.java`
3. Right-click `ReserveMyParkTest.java`.
4. Select **Run 'ReserveMyParkTest'**.
5. The IDE will run all 13 JUnit tests.

A successful run should show **13 tests passed** with no failures or errors.

## Test Documentation

The test planning and test cases are located in the `docs/` directory.

### TCI.md

`docs/TCI.md` contains the **Test Coverage Items (TCIs)** used to develop the test suite.

### TestCases.md

`docs/TestCases.md` contains the **13 concrete test cases** created from the TCIs.

The JUnit tests in `ReserveMyParkTest.java` implement these documented test cases.

## Test Coverage

### Nights — Boundary Value Analysis

The tests cover:

* 0 — below minimum
* 1 — minimum
* 14 — maximum
* 15 — above maximum

### Guest Age — Boundary Value Analysis and Equivalence Partitioning

The tests cover:

* -1 — invalid age
* 0 — minimum child age
* 12 — maximum child age
* 13 — minimum adult age
* 64 — maximum adult age
* 65 — minimum senior age

### Residency and Veteran Status — Decision Table

The Decision Table accounts for all combinations of:

* Resident + Veteran
* Resident + Not Veteran
* Not Resident + Veteran
* Not Resident + Not Veteran

Duplicate test cases are eliminated when an existing test case already covers a Decision Table combination.

## Project Structure

```text
.
├── pom.xml
├── README.md
├── docs/
│   ├── TCI.md
│   └── TestCases.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── baarsch_bytes/
    │               ├── Exceptions/
    │               │   ├── GuestAgeReservationException.java
    │               │   ├── NightReservationException.java
    │               │   └── ReservationException.java
    │               └── UnitTesting/
    │                   └── ReserveMyPark.java
    └── test/
        └── java/
            └── com/
                └── baarsch_bytes/
                    └── UnitTesting/
                        └── ReserveMyParkTest.java
```
