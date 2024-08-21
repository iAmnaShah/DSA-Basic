//Linked List Based
class QueueLinked {
    Node front;
    Node rear;

    public QueueLinked() {
        front = rear = null;
    }

    boolean enqueue(int v) {
        Node newNode = new Node(v);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        return true;
    }

    Node dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            Node removedNode = front;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return removedNode;
        }
    }

    boolean isFull() {
        // Linked list implementation doesn't have a fixed size, so it's never "full."
        return false;
    }

    boolean isEmpty() {
        return front == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = front;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    Node front() {
        return front;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        QueueLinked queue = new QueueLinked();

        // Enqueue some elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue: " + queue);

        // Dequeue elements
        Node dequeuedNode = queue.dequeue();
        if (dequeuedNode != null) {
            System.out.println("Dequeued: " + dequeuedNode.data);
        } else {
            System.out.println("Queue is empty, cannot dequeue.");
        }

        dequeuedNode = queue.dequeue();
        if (dequeuedNode != null) {
            System.out.println("Dequeued: " + dequeuedNode.data);
        } else {
            System.out.println("Queue is empty, cannot dequeue.");
        }

        System.out.println("Updated Queue: " + queue);
    }
}
