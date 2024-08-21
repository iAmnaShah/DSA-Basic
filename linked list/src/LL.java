import javax.swing.*;

public class LL {
    private Node head;
    private int size;
    LL(){
        this.size = 0;
    }

    class Node {
        private int value;
        private Node next;
        private Node node;
        Node( int value){
            this.value = value;
            this.next = null;
            size++;
        }
        Node (int value, Node node){
            this.value = value;
            this.next = null;
            this.node = node;
        }
    }
    public void addfirst(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
   }
   public void addlast(int value){
        Node currentnode = head;
        Node node = new Node(value);
        if(head == null){
            head = node;
            return;
        }
        while (currentnode.next!= null){
            currentnode = currentnode.next;
        }
        currentnode.next = node;
    }
    public void deletefrst() {
        Node node = new Node(head.value);
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        size--;
        head = head.next;


    }
    public void deletelast(){
        Node node = new Node(head.value);
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            size--;
            return;
        }

        Node secnode = head;
        Node lastnode = head.next;
        while (lastnode.next != null){
            lastnode = lastnode.next;
            secnode = secnode.next;
        }
        secnode.next = null;
        size--;
    }
    public void delatlocation(int position)
    {
        if( position <= 0 ){
            System.out.println("Invalid position");
        }
        if (position == 1){
            head = head.next;
            size--;
            return;
        }
        Node previous = null;
        Node current = head;
        int Currentpos = 1;
        while (current != null && Currentpos < position){
            previous = current;
            current = current.next;
            Currentpos++;
        }
        if(current == null)
        {
            System.out.println("Position not found");
        }
        previous.next = current.next;
        size--;
    }
    public void addatloc(int position, int value){
        Node node = new Node(value);
        int Currentpos = 1;
        Node previous = null;
        Node current = head;
        if( position <= 0 ){
            System.out.println("Invalid position");
        }
        if (position == 1){
            node.next = head;
            head = node;
        }
        while (current != null && Currentpos < position){
            previous = current;
            current = current.next;
            Currentpos++;
        }
        if(current == null){
            System.out.println("Position not found");
        }
        previous.next = node;
        node.next = current;
        size ++;

    }
    public void findpos(int target) {
        int position = 0;
        Node current = head;
        while (current != null) {
            if (current.value == target) {
                System.out.println("Value " + target + " found at position " + position);
                return;
            }
            current = current.next;
            position++;

        }
        System.out.println("Value not found");
    }
    public int getSize(){
        return size;
    }
    public void print(){
        Node currentnode = head;
        while (currentnode != null){
            System.out.print("  -> "+currentnode.value);
            currentnode = currentnode.next;
        }
        System.out.print(" -> NULL");

    }

    // remove every node which has a node with a greater value anywhere to the right side of it.
    public void removenode(Node head){
        Node max = head;
        Node current = head;
        Node prev = null;
        while (current!=null && current.next != null){
            if(current.next.value > max.value ) {
                max = current.next;
            }
               else {
                   current.next = current.next.next;
               }
            }
            if (current.next==null)
                prev = current;
            current = current.next;

        }
    }

