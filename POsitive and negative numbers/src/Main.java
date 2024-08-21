class Node {
    int value;
    Node next;
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList{
    Node head;
    public void addnum(int value) {
        Node node = new Node(value);
        //corner case
        if (head == null) {
            head = node;
        }
        else {
            Node Current = head;
            while (Current.next != null) {
                Current = Current.next;
            }
            Current.next = node;
        }
    }
    //passing the linked  lists in function
    public void separateinteger(LinkedList positivenumber,
                            LinkedList negativenumber) {
        Node Current = head;
        while (Current != null) {
            //condition for positive numbers in the list
            if (Current.value > 0) {
                positivenumber.addnum(Current.value);
            }
            //condition for negative numbers in the list
            else {
                negativenumber.addnum(Current.value);
            }
            Current = Current.next;
        }
    }//displaying the numbers
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        //creating 3 objects for linked list class
        LinkedList originalList = new LinkedList();
        LinkedList positivenum = new LinkedList();
        LinkedList negativenum = new LinkedList();
        //adding numbers to original linked lists
        originalList.addnum(25);
        originalList.addnum(-13);
        originalList.addnum(70);
        originalList.addnum(-23);
        originalList.addnum(82);
        originalList.addnum(-112);

        System.out.println("Original Linked List:");
        originalList.display();

        originalList.separateinteger(positivenum, negativenum);
        //adding number to positive linked lists
        System.out.println("Positive Linked List:");
        positivenum.display();
        //adding number to negative linked lists
        System.out.println("Negative Linked List:");
        negativenum.display();
    }
}
