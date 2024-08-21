import java.util.Arrays;
import java.util.Scanner;

public class Maxnumber {
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
        int max = maxnum(array);
        System.out.println("The maximum number in the array is: "+max);
        int secmax = secmax(array,max);
        System.out.println("The second maximum number in the array is: "+secmax);
    }
    static  int maxnum(int[] arr)
    {
        int max = arr[0];
        for(int i=1; i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    static int secmax(int[] arr,int max)
    {
        int secmax = arr[0];
        for(int i=1; i< arr.length;i++)
        {
            if(arr[i]<max&&arr[i]>secmax)
            {
                secmax=arr[i];
            }
        }
        return secmax;
    }
}
