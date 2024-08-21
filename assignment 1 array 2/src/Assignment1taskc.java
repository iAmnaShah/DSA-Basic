
import java.util.Scanner;

public class Assignment1taskc {
    public static void main(String[] args) {
        System.out.println("Enter size Of Array: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
       Array array = new Array(size);
        int[] array =Array.getArray();
        System.out.println("Array: ");
        for(int value: array)
        {
            System.out.println(" "+value);
        }
    }
}

class Array {
    private int[] array;
    public Array(int size)
    {
        array = new int[size];
        for(i=1; i<size;i++)
        {
            array[i] = i;
        }

    }
    public int[] getArray()
    {
        return array;
    }
}
