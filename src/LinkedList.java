public class LinkedList {
    Node head;
    LinkedList completedTasks = new LinkedList(); // To store completed tasks

    public void add(Task task) {
        if (task == null || task.getName() == null) {
            System.out.println("Error: Invalid task.");
            return;
        }
        Node node = new Node(task);
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void addFirst(Task task) {
        if (task == null || task.getName() == null) {
            System.out.println("Error: Invalid task.");
            return;
        }
        Node node = new Node(task);
        node.next = head;
        head = node;
    }

    public void remove(String name) {
        if (head == null) {
            System.out.println("Error: Task list is empty.");
            return;
        }
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Task name cannot be null or empty.");
            return;
        }
        if (head.task.getName().equals(name)) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.task.getName().equals(name)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void markCompleted(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Task name cannot be null or empty.");
            return;
        }
        Node node = head;
        while (node != null) {
            if (node.task.getName().equals(name)) {
                node.task.markCompleted();
                completedTasks.add(node.task); // Add to completedTasks list
                remove(name); // Remove from the main list
                return;
            }
            node = node.next;
        }
        System.out.println("Error: Task not found.");
    }

    public void show() {
        if (head == null ) {
            System.out.println("No tasks to show.");
            return;
        }
        Node node = head;
        while (node != null) {
            System.out.println("Name: " + node.task.getName() + ", Date: " + node.task.getDate() + ", Priority: " + node.task.getPriority() + ", Category: " + node.task.getCategory() + ", Completed: " + node.task.isCompleted());
            node = node.next;
        }
    }

    public void showCompleted() {
        if (completedTasks.head == null) {
            System.out.println("No completed tasks.");
            return;
        }
        Node node = completedTasks.head;
        while (node != null) {
            System.out.println("Name: " + node.task.getName() + ", Date: " + node.task.getDate() + ", Priority: " + node.task.getPriority() + ", Category: " + node.task.getCategory());
            node = node.next;
        }
    }

    public void showUrgent() {
        if (head == null) {
            System.out.println("No tasks to show.");
            return;
        }
        Node node = head;
        boolean hasUrgent = false;
        while (node != null) {
            if (node.task.getPriority().equals("urgent")) {
                hasUrgent = true;
                System.out.println("Name: " + node.task.getName() + ", Date: " + node.task.getDate() + ", Priority: " + node.task.getPriority() + ", Category: " + node.task.getCategory());
            }
            node = node.next;
        }
        if (!hasUrgent) {
            System.out.println("No urgent tasks.");
        }
    }

    public void showByCategory(String category) {
        if (category == null || category.isEmpty()) {
            System.out.println("Error: Category cannot be null or empty.");
            return;
        }
        if (head == null) {
            System.out.println("No tasks to show.");
            return;
        }
        Node node = head;
        boolean hasCategory = false;
        while (node != null) {
            if (node.task.getCategory().equals(category)) {
                hasCategory = true;
                System.out.println("Name: " + node.task.getName() + ", Date: " + node.task.getDate() + ", Priority: " + node.task.getPriority() + ", Category: " + node.task.getCategory() + ", Completed: " + node.task.isCompleted());
            }
            node = node.next;
        }
        if (!hasCategory) {
            System.out.println("No tasks found in the specified category.");
        }
    }
}
