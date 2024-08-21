import java.util.Arrays;
import java.util.Scanner;

public class serachin2Darray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        System.out.println("Enter number of rows:");
        row = scan.nextInt();
        System.out.println("Enter number of col");
        col = scan.nextInt();
        int[][] array = new int[row][col];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < row; i++) {
            for(int j = 0; j<col;j++)
            {
                array[i][j] = scan.nextInt();
            }
        }
        for(int i[]:array)
        System.out.println(Arrays.toString(i));
        search2D(array);
    }
    static void search2D(int [][] array)
    {
        int target;
        boolean found = true;
        System.out.println("Enter the number you want to find:");
        Scanner scan = new Scanner(System.in);
        target = scan.nextInt();
        for(int i = 0 ;i<array.length;i++)
        {
            for(int j =0;j<array[i].length;j++)
            {
                if(array[i][j]==target)
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            System.out.println("Target "+target+"found.");
        }
        else
        {
            System.out.println("Target"+target+" not found");
        }

    }

}
