class CircularQueue {
    int[] arr;
    int front; // indicating head
    int rear; // indicating tail
    int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = rear = -1;
    }

    boolean enqueue(int v) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        arr[rear] = v;
        return true;
    }

    int dequeue() {
        if (isEmpty()) {
            return -1; // Assuming -1 indicates an empty queue
        }

        int removedValue = arr[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return removedValue;
    }

    boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    boolean isEmpty() {
        return front == -1;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = front;
        while (true) {
            sb.append(arr[i]);
            if (i == rear) {
                break;
            }
            sb.append(", ");
            i = (i + 1) % capacity;
        }
        sb.append("]");
        return sb.toString();
    }

    int front() {
        if (isEmpty()) {
            return -1; // Assuming -1 indicates an empty queue
        }
        return arr[front];
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a circular queue with a capacity of 3
        CircularQueue circularQueue = new CircularQueue(3);

        // Enqueue elements
        circularQueue.enqueue(5);
        circularQueue.enqueue(15);
        circularQueue.enqueue(25);

        // Display the queue
        System.out.println("CircularQueue: " + circularQueue.toString());

        // Dequeue elements
        int dequeuedValue = circularQueue.dequeue();
        if (dequeuedValue != -1) {
            System.out.println("Dequeued: " + dequeuedValue);
        }

        // Display the updated queue
        System.out.println("CircularQueue: " + circularQueue.toString());

        // Enqueue one more element
        circularQueue.enqueue(35);

        // Display the updated queue
        System.out.println("CircularQueue: " + circularQueue.toString());

        // Attempt to enqueue when the queue is full
        boolean result = circularQueue.enqueue(45);
        if (!result) {
            System.out.println("Enqueue failed: Queue is full.");
        }

        // Display the final queue
        System.out.println("CircularQueue: " + circularQueue.toString());

        // Get the front element
        int frontValue = circularQueue.front();
        if (frontValue != -1) {
            System.out.println("Front element: " + frontValue);
        }
    }
}


