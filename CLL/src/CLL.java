public class CLL {
    Node head;
    Node tail;

    class Node {
        int value;
        Node next;
        Node previous;
        Node current;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    public void addfirst(int value){
        Node node = new Node(value);
        if(head==null){
            head = node;
            tail = node;
            tail.next = head;
        }else {
            node.next = head;
            tail.next = node;
            head = node;
        }
    }
    public void addatloc(int pos, int value){
        Node node = new Node(value);
        int position = 1;
        Node cuurent = head;
        if(head == null){
            head = node;
            tail = node;
            tail.next = head;
        }
        while(cuurent.next!=null && position < pos - 1){
            cuurent = cuurent.next;
            position++;
        }
        if (cuurent == null){
            System.out.println("Positon not found");
        }
        node.next = cuurent.next;
        cuurent.next = node;


    }
    public void addlast(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
            tail.next = head;
        }
        else{
            tail.next = node;
            tail = node;
            tail.next = head;
        }
    }
    public void delfirst(){
        if(head == null){
            System.out.println("List is empty");
        }
        if(head == tail){
            head = null;
            tail = null;
        }
        else {
            tail.next = head.next;
            head = tail.next;
        }
    }
    public void dellast(){
        Node curent = head;
        if(head == null){
            System.out.println("List is empty");
        }
        if(head == tail){
            head = null;
            tail = null;
        }
        else{
            while(curent.next != tail){
                curent = curent.next;
            }
            curent.next = head;
            tail = curent;
            head = tail.next;
        }
    }
    public void delatloc(int pos){
        Node current = head;
        Node previous = null;
        int currentpos = 1;
        if(head == null){
            System.out.println("List is empty");
        }
        if(head == tail){
            head = null;
            tail = null;
        }
        else{
            while (current.next != tail && currentpos < pos){
                previous = current;
                current = current.next;
                currentpos ++;
            }
            previous.next = current.next;
            if (current == tail){
                tail = previous;
            }

        }
    }
    public void display(){
        Node current = head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        do{
            System.out.print(" -> "+current.value);
            current = current.next;
        }while (current!=head);
    }
}
