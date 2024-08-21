
import java.util.Arrays;
import java.util.Scanner;

public class binarysearch {
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
        sortascending(array);
        System.out.println("Enter the value you want to search:");
        int key = scan.nextInt();
        search(array,key);

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
        System.out.println(Arrays.toString(array));
    }
    static void search(int[] array,int key)
    {
        boolean found = true;
        int index = 0;
        for(int i =0;i<array.length;i++)
        {
            if(key==array[i])
            {
                found = true;
                index = i;
            }
            else
            {
                found = false;
            }
        }
        if(found)
        {
            System.out.println("The value "+key+" found at index "+index);
        }
        else
        {
            System.out.println("The value "+key+" not found");
        }

    }
}
