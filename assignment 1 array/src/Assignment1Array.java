import java.util.Random;
import java.util.Scanner;

public class Assignment1Array {
    public static void main(String[] args) {
        Array array = new Array();
        System.out.println("Array of random numbers:");
        array.print();
        int value = 72;
        int result = array.binarysearch(value);
        if(result!=-1)
            System.out.println("Value "+value+" is at index"+result);
        else
            System.out.println("Value"+value+" not found");
        array.search(value);
        array.deleteatstart();
        array.deleteatend();
        array.deleteatlocation();
        array.insertatstart();
        array.insertatend();
        array.insertatlocation();
        array.sortascending();
        array.sortdescending();
        //task c
        System.out.println("Array of size enter by user:");
        Scanner scanner= new Scanner(System.in);
        int size= scanner.nextInt();
        System.out.println("Enter size to make an array of natural numbers:");

        Array array1 = new Array(size);
        array1.populateArr();
        array1.printarr();
    }

}


interface listADT {

    public void printarr();
    public void populateArr();
    public void initialize();
    public void print();
    public void search(int value) ;
    public void deleteatstart();
    public void deleteatend();
    public void deleteatlocation();
    public void insertatstart();
    public void insertatend();
    public void insertatlocation();
    public void sortascending();
    public void sortdescending();







}

class Array {
    private int array[];
    private int size;
    private int arr[];
    private int size1;

    public Array() {
        size = 10;
        array = new int[size];
        initialize();
    }
    public Array(int size1){
        this.size1= size1;
        arr= new int[size1];
    }
    public void populateArr(){
        for (int i=1; i<=size1; i++){
            arr[i-1]= i;
        }
    }
    public void printarr(){
        int i = 0;
        while (i < size1) {
            System.out.println(" " + arr[i]);
            i++;
        }
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
    public int binarysearch(int key)
    {
        sortascending();
        int left = 0;
        int right = size-1;
        while(left<=right)
        {
            int mid = left + (right - left) / 2;
            if(array[mid] == key)
            {
                return mid;
            }
            if (array[mid]<key)
            {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;

    }
}

