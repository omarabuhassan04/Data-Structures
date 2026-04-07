import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Stack stack = new Stack();
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1- Add new task");
            System.out.println("2- Mark task as completed");
            System.out.println("3- Show completed tasks");
            System.out.println("4- Show urgent tasks");
            System.out.println("5- Show tasks by category");
            System.out.println("6- Display all tasks");
            System.out.println("7- Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter task name: ");
                        String name = scanner.nextLine();
                        if (name.isEmpty()) {
                            System.out.println("Error: Task name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter task date (yyyy-mm-dd): ");
                        String dateInput = scanner.nextLine();
                        LocalDate date;
                        try {
                            date = LocalDate.parse(dateInput);
                        } catch (Exception e) {
                            System.out.println("Error: Invalid date format.");
                            break;
                        }

                        System.out.print("Enter task priority (low, medium, urgent): ");
                        String priority = scanner.nextLine();
                        if (!priority.equals("low") && !priority.equals("medium") && !priority.equals("urgent")) {
                            System.out.println("Error: Invalid priority. Please enter low, medium, or urgent.");
                            break;
                        }

                        System.out.print("Enter task category: ");
                        String category = scanner.nextLine();
                        if (category.isEmpty()) {
                            System.out.println("Error: Task category cannot be empty.");
                            break;
                        }

                        Task newTask = new Task(name, date, priority, category);
                        if (newTask.getName() == null) {
                            // Task was not created successfully, due to earlier validation errors.
                            break;
                        }
                        list.add(newTask);
                        if (priority.equals("urgent")) {
                            stack.push(newTask);
                        } else {
                            queue.enqueue(newTask);
                        }
                        break;

                    case 2:
                        System.out.print("Enter task name to mark as completed: ");
                        String completedTaskName = scanner.nextLine();
                        if (completedTaskName.isEmpty()) {
                            System.out.println("Error: Task name cannot be empty.");
                        } else {
                            list.markCompleted(completedTaskName);
                        }
                        break;

                    case 3:
                        System.out.println("Completed Tasks:");
                        list.showCompleted();
                        break;

                    case 4:
                        System.out.println("Urgent Tasks:");
                        stack.show();
                        break;

                    case 5:
                        System.out.print("Enter category to filter by: ");
                        String filterCategory = scanner.nextLine();
                        if (filterCategory.isEmpty()) {
                            System.out.println("Error: Category cannot be empty.");
                        } else {
                            System.out.println("Tasks in category '" + filterCategory + "':");
                            list.showByCategory(filterCategory);
                        }
                        break;

                    case 6:
                        System.out.println("All Tasks:");
                        list.show();
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                scanner.next();  // Consume invalid input
            }
        }
    }
}
