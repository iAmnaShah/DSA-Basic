import java.util.Arrays;
import java.util.Scanner;

public class Minnumber {
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
        int min = minnum(array);
        System.out.println("The maximum number in the array is: "+min);
    }
    static int minnum(int[] arr)
    {
        int min = arr[0];
        for(int i=1; i<arr.length;i++)
        {
            if(arr[i]<min)
            {
                min = arr[i];
            }
        }
        return min;
    }
}
