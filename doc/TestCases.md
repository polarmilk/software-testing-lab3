# Test Cases
This file contains the test suite with test cases covering the 
test coverage items from the TCI.md file.

## Test Suite Table
Each test case contains the TCIs covered, a description, the parameter values, and the expected outcome.

| Test Case | TCIs Covered                                | Description                     | Nights | Guest Age | Resident | Veteran | Expected Outcome             |
|---|---------------------------------------------|---------------------------------|---:|---:|---|---|------------------------------|
| TC1 | BVA1.1                                      | Just below minimum stay         | 0 | 26 | F | F | NightReservationException    |
| TC2 | BVA1.2, Resident Flag = F, Veteran Flag = F | Minimum stay, not resident or veteran | 1 | 26 | F | F | $50                          |
| TC3 | BVA1.3                                      | Maximum stay                    | 14 | 26 | F | F | $700                         |
| TC4 | BVA1.4                                      | Just above maximum stay         | 15 | 26 | F | F | NightReservationException    |
| TC5 | BVA2.1, EP2.1                               | Just below minimum age          | 1 | -1 | F | F | GuestAgeReservationException |
| TC6 | BVA2.2, EP2.2                               | Minimum age / child             | 1 | 0 | F | F | $25                          |
| TC7 | BVA2.3, EP2.2                               | Child maximum age               | 1 | 12 | F | F | $25                          |
| TC8 | BVA2.4, EP2.3                               | Adult minimum age               | 1 | 13 | F | F | $50                          |
| TC9 | BVA2.5, EP2.3                               | Adult maximum age               | 1 | 64 | F | F | $50                          |
| TC10 | BVA2.6, EP2.4                               | Senior minimum age              | 1 | 65 | F | F | $40                          |
| TC11 | Resident Flag = T, Veteran Flag = T         | Resident and veteran            | 1 | 26 | T | T | $36                          |
| TC12 | Resident Flag = T, Veteran Flag = F         | Resident only                   | 1 | 26 | T | F | $40                          |
| TC13 | Resident Flag = F, Veteran Flag = T         | Veteran only                    | 1 | 26 | F | T | $45                          |

> **Note:** The `Resident = F, Veteran = F` decision-table combination is covered by TC2. A separate test case was omitted because it would duplicate TC2's parameter values and expected outcome.