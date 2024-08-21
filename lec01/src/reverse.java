import java.util.Arrays;
import java.util.Scanner;

public class reverse {
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
        reverse(array);
    }
    static void reverse(int[] arr)
    {
        int start=0;
        int end = arr.length - 1;
        while(start<end)
        {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;

        }
        System.out.println(Arrays.toString(arr));
    }
}

