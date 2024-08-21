 class Node {
            int data;
            Node next;
            public Node(int data) {
                this.data = data;
                this.next = null;
            }
            public Node() {
                this.data = 0;
                this.next = null;
            }
        }
        class LinkedList {
            private Node head;
            private int size;

            // Constructor
            public LinkedList() {
                head = null;
                size = 0;
            }
            public void add(int data) {
                Node newNode = new Node(data);
                if (head == null) {
                    head = newNode;
                } else {
                    Node current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                }
                size++;
            }
            public boolean remove(int data) {
                if (head == null) {
                    return false;
                }

                if (head.data == data) {
                    head = head.next;
                    size--;
                    return true;
                }

                Node current = head;
                while (current.next != null) {
                    if (current.next.data == data) {
                        current.next = current.next.next;
                        size--;
                        return true;
                    }
                    current = current.next;
                }

                return false;
            }
            public int get(int index) {
                if (index < 0 || index >= size) {
                    throw new IndexOutOfBoundsException("Index is out of bounds");
                }

                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }

                return current.data;
            }
            public int size() {
                return size;
            }
            public boolean isEmpty() {
                return size == 0;
            }
        }

        class Main {
            public static void main(String[] args) {
                LinkedList myList = new LinkedList();

                myList.add(1);
                myList.add(2);
                myList.add(3);

                System.out.println("Size of the list: " + myList.size());
                System.out.println("Is the list empty? " + myList.isEmpty());

                System.out.println("Element at index 1: " + myList.get(1));

                myList.remove(2);
                System.out.println("Size of the list after removing an element: " + myList.size());
            }
        }


