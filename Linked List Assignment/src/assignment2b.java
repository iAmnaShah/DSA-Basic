public class assignment2b {
        public static void main(String[] args) {
            int[] myArray = {15, 29, 33, 48, 56};
            int targetElement = 36;
            int result = linearSearch(myArray, targetElement);
            if (result != -1) {
                myPrint("Element " + targetElement + " found at index " + result);
            } else {
                myPrint("Element " + targetElement + " not found in the array");
            }
        }
        public static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        public static void myPrint(String text) {
            System.out.println(text);
        }
    }

