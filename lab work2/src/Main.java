import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListADT listADT = new ListADT();
        ArrayListADT arrayListADT = new ArrayListADT();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array:");
        listADT.print();
        int value = 72;
        listADT.search(value);
        listADT.deleteatstart();
        listADT.deleteatend();
        listADT.deleteatlocation();
        listADT.insertatstart();
        listADT.insertatend();
        listADT.insertatlocation();
        listADT.sortascending();
        listADT.sortdescending();
    }

}


class ListADT {
    protected int array[];
    protected int size;

    public ListADT(int size) {
        this.size = size;
        array = new int[size];
        initialize();
    }

    public void initialize() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(150);
        }
    }

    public void print() {
        int i = 0;
        while (i < size) {
            System.out.println(" " + array[i]);
            i++;
        }
    }

    public void search(int value) {
        int index = 0;
        boolean found = false;
        while (index < size) {
            if (array[index] == value) {
                System.out.println("value  " + value + " is at index " + index);
                found = true;
            }
            index++;
        }
        if (!found) {
            System.out.println("Value " + value + " not found");
        }
    }

    public void deleteatstart() {
        System.out.println("DELETE AT START OF ARRAY");
        int[] array1 = new int[size - 1];
        int index = 1; //setting index to 1
        System.out.println("Before deletion array: ");
        //Showing array before deleting 1st element
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        //Logic
        while (index < size) {
            //copying array into a new array
            array1[index - 1] = array[index];
            index++;
        }
        //Showing array after deletion
        System.out.println(" After deletion array: ");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(" " + array1[i]);
        }
    }

    public void deleteatend() {
        System.out.println();
        System.out.println("DELETE AT END OF ARRAY");
        int[] array2 = new int[size - 1];
        int index = 0;
        System.out.println("Before deletion array: ");
        //Showing array before deleting last element
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        //Logic
        while (index < size - 1) {
            //copying array into a new array
            array2[index] = array[index];
            index++;
        }
        //Showing array after deletion
        System.out.println(" After deletion array: ");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(" " + array2[i]);
        }
    }

    public void deleteatlocation() {
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


    public void insertatstart() {
        System.out.println();
        System.out.println("INSERT AT START OF ARRAY");
        int[] array1 = new int[size + 1];
        Random random = new Random();
        int index = 0; //setting index to 0
        System.out.println("Before insertion array: ");
        //Showing array before inserting 1st element
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        //Logic
        array1[0] = random.nextInt(10);
        while (index < size) {

            array1[index + 1] = array[index];
            index++;
        }
        //Showing array after deletion
        System.out.println(" After insertion array: ");
        for (int i = 0; i < size + 1; i++) {
            System.out.print(" " + array1[i]);
        }
    }

    public void insertatend() {
        System.out.println();
        System.out.println("INSERT AT END OF ARRAY");
        int[] array1 = new int[size + 1];
        Random random = new Random();
        int index = 0; //setting index to 0
        System.out.println("Before insertion array: ");
        //Showing array before inserting last element
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        //Logic
        while (index < size) {
            array1[index] = array[index];
            index++;
        }
        array1[size] = random.nextInt(10);
        //Showing array after insertion
        System.out.println(" After insertion array: ");
        for (int i = 0; i < size + 1; i++) {
            System.out.print(" " + array1[i]);
        }
    }

    public void insertatlocation() {
        System.out.println();
        System.out.println("INSERT AT SPECIFIC INDEX OF ARRAY");
        int[] array1 = new int[size + 1];
        int index = 0;
        int key;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index(0-9) at which you want to add");
        key = scan.nextInt();//Taking Input
        System.out.println("Before insertion array: ");
        //Showing array before inserting element at specific location
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();

        //Logic
        while (index < size) {
            if (index < key) {
                array1[index] = array[index];
            } else if (index == key) {
                Random random = new Random();
                array1[key] = random.nextInt(50);
            } else if (index > key) {
                array1[index] = array[index - 1];
            }
            index++;
        }
        //Showing array after insertion
        System.out.println(" After insertion array: ");
        for (int i = 0; i < size + 1; i++) {
            System.out.print(" " + array1[i]);
        }
    }


    public void sortascending() {
        int temp = 0;
        System.out.println();
        System.out.println("ARRAY LIST IN ASCENDING ORDER:");
        //Logic
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("" + array[i]);
        }

    }

    public void sortdescending() {
        int temp = 0;
        System.out.println();
        System.out.println("ARRAY LIST IN DESCENDING ORDER:");
        //Logic
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("" + array[i]);
        }


    }
}






