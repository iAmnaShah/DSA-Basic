public class DLL {
    Node head;
    Node tail;
    class Node{
        Node node;
        private int value;
        Node next;
        Node previous;
        Node(int value){
            this.value = value;
            this.next = next;
        }
    }
    public void addfirst(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head.previous = null;
        head = node;
    }

    public void addlast(int value){
        Node node = new Node(value);
        Node current = head;
        if(head == null){
            head = node;
            return;
        }
        while (current.next!=null){
            current = current.next;
        }
        current.next = node;
        node.next = null;
        node.previous = current;
    }

    public void addatloc(int position, int value){
        Node node = new Node(value);
        Node current = head;
        Node previous = null;
        int currentpos = 1;
        if(head == null){
            head = node;
            return;
        }
        while(current.next!=null && currentpos < position){
            previous = current;
            current = current.next;
            currentpos++;
        }
        node.next = current;
        previous.next = node;
    }
    public void printnode(){
        Node currentnode = head;
        while (currentnode != null){
            System.out.print("-> "+currentnode.value);
            currentnode = currentnode.next;
        }
        System.out.print(" -> NULL ");

    }

    public void reverseprint() {
        Node currentnode = head;
        while (currentnode.next != null){
            currentnode = currentnode.next;
        }
        while (currentnode != null){
            System.out.println(" -> "+currentnode.value);
            currentnode = currentnode.previous;
        }
        System.out.println(" -> NULL ");
    }



}
