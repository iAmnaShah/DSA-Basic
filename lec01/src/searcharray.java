import java.util.Arrays;
import java.util.Scanner;

public class searcharray {
    public static void main(String[] args)
    {
        int size;
        int key;
        System.out.println("Enter size of array:");
        Scanner scan = new Scanner(System.in);
        size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Enter elements of array:");
        for(int i=0; i<array.length;i++)
        {
            array[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Enter the value you want to search:");
        key = scan.nextInt();
        search(array,key);
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
