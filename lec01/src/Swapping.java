import java.util.Arrays;
import java.util.Scanner;


public class Swapping {
    public static void main(String[] args) {
        int size;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array:");
        size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }

        System.out.println(Arrays.toString(array));
        Swap(array);
    }

        static void Swap(int[] arr)
        {
            int index1;
            int index2;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter 1st index:");
            index1 = scan.nextInt();
            System.out.println("Enter 2nd index:");
            index2 = scan.nextInt();
            int temp;
            temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
            System.out.println(Arrays.toString(arr));
        }

 }


