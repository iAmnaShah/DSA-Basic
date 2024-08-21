class QuickSort {
    // Function to partition the array and return the pivot index
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Function to perform Quick Sort
    void sort(int arr[], int low, int high) {
        if (low < high) {
            // Find pivot element such that
            // elements smaller than pivot are on the left and greater are on the right
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // Function to print the array
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        QuickSort quickSort = new QuickSort();
        System.out.println("Given Array:");
        quickSort.printArray(arr);

        quickSort.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        quickSort.printArray(arr);
    }
}
