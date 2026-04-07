# Data Structures — Task Management System

A Java-based Task Management System built to demonstrate core data structures. The application uses a **Linked List** to store all tasks, a **Stack** for urgent task management (LIFO), and a **Queue** for regular tasks (FIFO). Features include adding tasks with priority levels, marking tasks as completed, filtering by category, and displaying urgent tasks. Sorting is implemented using **Merge Sort** and **Selection Sort**, with performance comparison via a built-in timer.

## Data Structures Used

| Structure | Purpose |
|-----------|---------|
| Linked List | Store and manage all tasks |
| Stack | Handle urgent tasks (LIFO) |
| Queue | Handle regular tasks (FIFO) |
| Array | Used for sorting comparisons |

## Features

- Add new tasks with name, date, priority (low / medium / urgent), and category
- Mark tasks as completed
- View completed tasks
- View urgent tasks (Stack)
- Filter tasks by category
- Display all tasks
- Sorting algorithms: Merge Sort & Selection Sort with performance timer

## How to Run

1. Open the project in **VS Code** with the Java Extension Pack installed
2. Navigate to `src/Main.java`
3. Run the `main` method

Or compile manually:
```bash
javac src/*.java
java -cp src Main
```

## Project Structure

```
Data Structures/
├── src/
│   ├── Main.java
│   ├── Task.java
│   ├── Node.java
│   ├── LinkedList.java
│   ├── Stack.java
│   ├── Queue.java
│   ├── Array.java
│   ├── MergeSort.java
│   ├── ESelectionSort.java
│   ├── Comparison.java
│   └── Timer.java
├── final report.docx
└── README.md
```

## Technologies

`Java` · `VS Code` · `Data Structures` · `OOP`

## Author

**Omar Abuhassan**
