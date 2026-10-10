# Student Grade Tracker

A console-based Java application for managing student scores.

## Features

- Add a student with a name and a score
- Delete a student by name (case-insensitive)
- View all students with their score and letter grade
- Summary report: total students, average score, highest scorer and lowest scorer
- Input validation: no crashes on letters, empty names or scores outside 0 to 100

## Concepts Used

- Object-Oriented Programming (`Student` model class, encapsulation with getters and setters)
- `ArrayList` for storing and managing data
- Loops, `if/else` and `switch`
- Exception handling (`try/catch` with `NumberFormatException`)
- Separation of concerns across packages

## Project Structure

```
src/
├── Menu.java                    # Entry point and console menu
├── model/
│   └── Student.java             # Student data (name, score)
├── services/
│   └── StudentService.java      # Add, delete, view, grading and statistics logic
└── utils/
    └── InputCheck.java          # Safe input reading and validation
```

## Grading Scale

| Score | Grade |
|-------|-------|
| 70 - 100 | A |
| 60 - 69 | B |
| 50 - 59 | C |
| 45 - 49 | D |
| 40 - 44 | E |
| 0 - 39 | F |

## How to Run

**Requirements:** JDK 8 or higher (check with `java -version`).

From the `src` folder:

```bash
javac Menu.java model/*.java services/*.java utils/*.java
java Menu
```

Or open the project in IntelliJ IDEA or Eclipse and run `Menu.java`.

## Sample Run

```
Enter the action you want to perform
Enter 1 to add student
Enter 2 to delete student
Enter 3 to view all students
Enter 4 to see summary report
Enter 0 to exit
Choose: 4
==== Summary Report ====
Total students : 3
Average score  : 83.5
Highest Score  : Abdulbasit (91.0)
Lowest Score   : Samuel (72.5)
```

## Known Limitations

- Data is stored in memory only and is lost when the program exits
- If two students share a name, delete removes only the first match
- Each student has one score (no multiple courses)

## Possible Improvements

- Save and load data from a file
- Update a student's score
- Sort the student list by score
- Support multiple courses per student
- Build a GUI version

## Author

Saadudeen Abdulabsit

Aspiring software Engineer
