import java.util.Arrays;
import java.util.Scanner;

public class lec01a {
    public static void main(String[] args) {
        int[][]arr = new int[3][3];
        //int[][] arr = {
          //      {1,2,3},{4,5,6},{7,8,9}
        //};
        Scanner scan = new Scanner(System.in);
        for(int row = 0; row< arr.length;row++)
        {
            for(int col = 0; col<arr[row].length;col++)
            {
                arr[row][col] = scan.nextInt();
            }
        }
        for(int[] a:arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}

