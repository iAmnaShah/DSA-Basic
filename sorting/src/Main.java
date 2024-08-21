import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of array:");
        size = scan.nextInt();
        int[] arr =  new int[size];
        System.out.println("Enter elements of array:");
        for(int i=0;i<size;i++)
        {
            arr[i] = scan.nextInt();
        }
        System.out.println("Unsorted Array:");
        System.out.println(Arrays.toString(arr));
        selectionsort(arr, size);
        System.out.println("Selection Sort:");
        System.out.println("In Ascending order:");
        System.out.println(Arrays.toString(arr));
        System.out.println("In Descending order:");
        selectionsortmax(arr,size);
        System.out.println(Arrays.toString(arr));
        System.out.println("Bubble Sort:");
        System.out.println("In Ascending order:");
        bubblesort(arr,size);
        System.out.println(Arrays.toString(arr));
        System.out.println("In Descending order:");
        bubblesortmax(arr,size);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionsort(int[] arr, int size) {
        int temp;
        int minindex;
        int min;
        for (int i = 0; i < size-1; i++) {
            minindex = i;
            min = arr[i];
            for(int j =i+1; j<size;j++) {
                if (arr[minindex] > arr[j]) {
                    min = arr[j];
                    minindex = j;
                }
            }
            temp = arr[minindex];
            arr[minindex] = arr[i];
            arr[i]= temp;
        }
    }
    static void selectionsortmax(int[] array, int size)
    {
        int temp;
        int maxindex = size -1;
        int max;
        for (int i = maxindex; i > 0; i--) {
            maxindex = i;
            max = array[i];
            for(int j = i-1; j>=0;j--) {
                if (array[maxindex] > array[j]) {
                    max = array[j];
                    maxindex = j;
                }
            }
            temp = array[maxindex];
            array[maxindex] = array[i];
            array[i]= temp;
        }
    }
    static void bubblesort(int[] array, int size)
    {
        int min = array[0];
        int temp;
        for(int i=0; i< size; i++)
        {
            for (int j = i+1; j<size; j++)
            {
                if(array[i] > array[j])
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    static void bubblesortmax(int[] array, int size)
    {
        int max = array[size-1];
        int temp;
        for(int i=size-1; i>0; i--)
        {
            for (int j = i-1; j>=0; j--)
            {
                if(array[i] > array[j])
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}