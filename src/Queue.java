public class Queue {
    LinkedList ln = new LinkedList();
    LinkedList completedTasks = new LinkedList();

    public Queue() {}

    public void enqueue(Task task) {
        if (task == null || task.getName() == null) {
            System.out.println("Error: Invalid task.");
            return;
        }
        Node newNode = new Node(task);
        if (ln.head == null || task.getDate().isBefore(ln.head.task.getDate())) {
            newNode.next = ln.head;
            ln.head = newNode;
        } else {
            Node current = ln.head;
            while (current.next != null && task.getDate().isAfter(current.next.task.getDate())) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void dequeue() {
        if (ln.head == null) {
            System.out.println("Error: Queue is empty.");
            return;
        }
        completedTasks.add(ln.head.task);
        ln.remove(ln.head.task.getName());
    }

    public void show() {
        System.out.println("\nCompleted Tasks:");
        completedTasks.show();
    }
}
