# Test Coverage Items
This file contains the TCIs for the nights, age, and residency & veteran status parameters for their assigned test paradigms.


## 1. Nights (BVA)
Minimum stay is 1 night; Maximum is 14 nights

### Table 1: Nights Boundary Value Analysis
| TCI    | Value | Description |
|--------|---:|---|
| BVA1.1 | 0 | Just below minimum |
| BVA1.2 | 1 | Minimum |
| BVA1.3 | 14 | Maximum |
| BVA1.4 | 15 | Just above maximum |


## 2. Age (BVA/EP)
- Child (0-12): 50% off
- Adult (13-64): Full price
- Senior (65+): 20% off
### Table 2.1: Age Boundary Value Analysis
| TCI    | Value | Description |
|--------|---:|---|
| BVA2.1 | -1 | Just below minimum |
| BVA2.2 | 0 | Child Minimum |
| BVA2.3 | 12 | Child maximum |
| BVA2.4 | 13 | Adult minimum |
| BVA2.5 | 64 | Adult maximum |
| BVA2.6 | 65 | Senior minimum |
### Table 2.2: Age Equivalence Partitions
| TCI   | Equivalence Partition | Description |
|-------|---:|---|
| EP2.1 | x < 0 | Invalid age |
| EP2.2 | 0 <= x <= 12| Child (0–12) |
| EP2.3 | 13 <= x <= 64 | Adult (13–64) |
| EP2.4 | x >= 65 | Senior (65+) |


## 3. Residency and Veteran Status (Decision Table)
- Arkansas Residents receive an additional $10 off the total
- Veterans receive a 10% discount
- Someone who is both an AR resident and veteran will first receive $10 off and then a 10% discount applied to the remainder
### Table 3: Res and Vet Status Decision Table
|  | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
|---|---|---|---|---|
| **Causes** |  |  |  |  |
| Resident Flag | T | T | F | F |
| Veteran Flag | T | F | T | F |
| **Effects** |  |  |  |  |
| Results | $10 off, then 10% | $10 off | 10% discount | No change |