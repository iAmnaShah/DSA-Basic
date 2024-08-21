import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //int[] num;//declaration
      // num  = new int[] { 2, 4, 6, 8, 10 };//initialization
        int[] num = new int[5];//declaring and initializing at same time
        Scanner scan = new Scanner(System.in);
        for(int i=0; i<num.length;i++)
        {
            num[i] = scan.nextInt();
        }
        //System.out.println(Arrays.toString(num));
        for(int a:num)
        {

            System.out.println(a);
        }
        //modify
        num[2] = 12;
        System.out.println(Arrays.toString(num));



    }
}