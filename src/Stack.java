public class Stack {
    LinkedList ln = new LinkedList();
    LinkedList urgentTasks = new LinkedList();

    public Stack() {}

    public void push(Task task) {
        if (task == null || task.getName() == null) {
            System.out.println("Error: Invalid task.");
            return;
        }
        if (!task.getPriority().equals("urgent")) {
            ln.add(task);
        } else {
            Node newNode = new Node(task);
            if (urgentTasks.head == null || task.getDate().isBefore(urgentTasks.head.task.getDate())) {
                newNode.next = urgentTasks.head;
                urgentTasks.head = newNode;
            } else {
                Node current = urgentTasks.head;
                while (current.next != null && task.getDate().isAfter(current.next.task.getDate())) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public void pop() {
        if (ln.head == null) {
            System.out.println("Error: Stack is empty.");
            return;
        }
        ln.remove(ln.head.task.getName());
    }

    public void show() {
        System.out.println("\nUrgent Tasks:");
        urgentTasks.show();
    }
}
