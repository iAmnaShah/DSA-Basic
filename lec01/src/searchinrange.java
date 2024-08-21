import java.util.Arrays;
import java.util.Scanner;

public class searchinrange {
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
        searchinrange(array);

    }
    static void searchinrange(int[] arr) {
        int target;
        int index = -1;
        boolean found = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter value you want to find:");
        target = scan.nextInt();
        for (int i=0; i<arr.length;i++) {
            if (target == arr[i]) {
                found = true;
                index = i;
                break;
            }
        }
        if(found)
        System.out.println("Number " + target + " found at index " + index);
        else
            System.out.println("Number not found");


    }

}
