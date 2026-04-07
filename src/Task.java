import java.time.LocalDate;

class Task {
    String name;
    LocalDate date;
    String priority;
    String category;
    boolean completed;

    Task(String name, LocalDate date, String priority, String category) {
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Task name cannot be null or empty.");
            return;
        }
        if (priority == null || (!priority.equals("low") && !priority.equals("medium") && !priority.equals("urgent"))) {
            System.out.println("Error: Invalid priority. Please enter low, medium, or urgent.");
            return;
        }
        if (category == null || category.isEmpty()) {
            System.out.println("Error: Task category cannot be null or empty.");
            return;
        }
        this.name = name;
        this.date = date;
        this.priority = priority;
        this.category = category;
        this.completed = false;
    }

    String getPriority() {
        return this.priority;
    }

    String getName() {
        return this.name;
    }

    LocalDate getDate() {
        return this.date;
    }

    String getCategory() {
        return this.category;
    }

    boolean isCompleted() {
        return this.completed;
    }

    void markCompleted() {
        this.completed = true;
    }
}
