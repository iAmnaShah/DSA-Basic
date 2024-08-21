import java.util.Arrays;
import java.util.Scanner;

public class sortarray {
    public static void main(String[] args) {
        int size;
        System.out.println("Enter size of array:");
        Scanner scan = new Scanner(System.in);
        size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(array));
        sortascending(array);
        sortdescending(array);
    }

    static void sortascending(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("Ascending Order:");
        System.out.println(Arrays.toString(array));
    }
    static void sortdescending(int[]array)
    {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("Descending Order:");
        System.out.println(Arrays.toString(array));


    }
}

