import java.util.Arrays;
import java.util.Scanner;

public class Deletearray {
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
        deleteatlocation(array,size);
    }
    static void deleteatlocation(int[] array, int size) {
        System.out.println();
        System.out.println("DELETE AT SPECIFIC INDEX OF ARRAY");
        int[] array3 = new int[size - 1];
        int index = 0;
        int key;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index(0-9) you want to delete");
        key = scan.nextInt();
        System.out.println("Before deletion array: ");//Taking Input
        //Showing array before deleting element at specific location
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();

        //Logic
        while (index < size) {
            if (index < key) {
                array3[index] = array[index];
            } else if (index > key) {
                array3[index - 1] = array[index];
            }
            index++;
        }
        //Showing array after deletion
        System.out.println(" After deletion array: ");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(" " + array3[i]);
        }
    }
}
