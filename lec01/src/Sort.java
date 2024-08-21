import java.util.Arrays;
import java.util.Scanner;

public class Sort {
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
        bubblesort(array,size);
    }
    static void bubblesort(int[] array,int size)
    {
        int temp;
        for(int i = 0; i< size;i++)
        {
            for(int j=0; j<size;j++)
            {
                if(array[i] < array[j])
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    static
}

