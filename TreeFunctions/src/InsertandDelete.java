class Heap {
    int heap[];
    int N;
    int n;

    // Default constructor to initialize a heap of size 5
    Heap() {
        N = 5;
        n = 0;
        heap = new int[N];
    }

    // Constructor to initialize heap of custom size
    Heap(int size) {
        N = size;
        n = 0;
        heap = new int[N];
    }

    boolean insertion(int val) {
        if (n >= N) {
            System.out.println("Heap is full, cannot insert more elements.");
            return false;
        }
        heap[n] = val;
        heapifyUp(n);
        n++;
        return true;
    }

    int deletion() {
        if (n <= 0) {
            System.out.println("Heap is empty, no elements to delete.");
            return -1; // Assuming -1 represents an empty heap
        }
        int deletedValue = heap[0];
        heap[0] = heap[n - 1];
        n--;
        heapifyDown(0);
        return deletedValue;
    }

    // Helper method to maintain heap property while inserting an element
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[parentIndex] > heap[index]) {
            // Swap values to maintain heap property
            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;

            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    // Helper method to maintain heap property while deleting an element
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < n && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < n && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }

        if (smallest != index) {
            // Swap values to maintain heap property
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;

            heapifyDown(smallest);
        }
    }
}
public class InsertandDelete {
    public static void main(String[] args) {
        // Creating a heap using the default constructor (size 5)
        Heap minHeap = new Heap();

        // Inserting elements into the heap
        minHeap.insertion(10);
        minHeap.insertion(20);
        minHeap.insertion(15);
        minHeap.insertion(30);
        minHeap.insertion(40);
        minHeap.insertion(5); // This will display a message that the heap is full

        // Deleting elements from the heap
        System.out.println("Deleted element: " + minHeap.deletion()); // Deleting the root element

        // Inserting another element after deletion
        minHeap.insertion(7);

        // Deleting elements until the heap is empty
        while (true) {
            int deleted = minHeap.deletion();
            if (deleted == -1) {
                System.out.println("Heap is empty");
                break;
            }
            System.out.println("Deleted element: " + deleted);
        }
    }
}

