class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList {
        Node head;
        int size;

        public LinkedList() {
            this.head = null;
            this.size = 0;
        }
        public LinkedList(int[] dataArr) {
            if (dataArr.length != 5) {
                throw new IllegalArgumentException("The data array must contain exactly 5 elements.");
            }

            this.head = new Node(dataArr[0]);
            Node current = this.head;
            this.size = 1;

            for (int i = 1; i < 5; i++) {
                Node newNode = new Node(dataArr[i]);
                current.next = newNode;
                current = newNode;
                this.size++;
            }
        }
        public int getSize() {
            return this.size;
        }

    }
    public class assignment2 {
        public static void main(String[] args) {
            int[] dataArr = {5, 4, 3, 2, 1};
            LinkedList linkedList = new LinkedList(dataArr);
            System.out.println("Size of the list: " + linkedList.getSize());
        }
}
