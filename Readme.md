# Tufin Developer Technical Assessment

## Programming Language and Version
Java 17

## Solution Explanations

### Question 1: GetLongestString
Uses a HashSet for O(1) valid character lookup and checks each string for consecutive identical characters and invalid characters. Returns the longest valid string.

### Question 2: firstUniqueProduct
Uses LinkedHashMap to maintain insertion order while counting occurrences, then returns the first product with count = 1.

### Question 3: ClosestMinimums
First finds the minimum value, then tracks the closest distance between any two occurrences of that minimum using a single pass.

### Question 4: ThreeMostCommon
Counts word frequencies using HashMap, sorts by frequency (desc) then alphabetically, takes top 3, and sorts final result alphabetically.

### Question 5: RotateList
Converts linked list to circular, calculates new head position, and breaks the circle at the appropriate point for O(n) time complexity.

## How to Run

For each Java file:
```bash
javac QuestionX_FileName.java
java QuestionX_FileName
```

For example:
```bash
javac Question1_GetLongestString.java
java Question1_GetLongestString
```

## Test Cases
Each file includes comprehensive test cases in the main method covering:
- Example scenarios from the problem statements
- Edge cases (empty inputs, null values, single elements)
- Boundary conditions
- Various data patterns

All solutions are designed to handle edge cases gracefully and include proper error handling where appropriate.