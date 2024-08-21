public class Main {
    public static void main(String[] args) {
       stack s = new stack();
       s.push(4);
       s.push(3);
       s.push(8);
       s.push(2);
       s.push(5);
       s.topelement();
       s.size();
       s.peek();
       s.pop();



    }
}
class Node{
    int value;
    Node prev;
    Node next;
    public Node(int value){
        this.value = value;
        this.next = null;
    }
}
class stack{
    public static Node top;
    public void push(int value){
        Node node = new Node(value);
        if(top == null){
            top = node;
            top.prev= null;
            top.next = null;
        }
        else {
            top.next = node;
            node.prev = top;
            top.next = null;
            top = node;
        }
    }
    public void pop(){
        Node node = top;
        if(node==null){
            System.out.println("Stack is empty");
        }
        else{
            top.prev.next= null;
            top = node.prev;
            }
        }

    public void peek(){
        Node temp = top;
        if(top==null){
            System.out.println("Stack is empty");
        }
        while (temp != null){
            System.out.println(" -> "+temp.value);
            temp = temp.prev;
        }
    }
    public void size(){
        int size = 0;
        Node temp = top;
        while (temp!=null){
            size++;
            temp = temp.prev;
        }
        System.out.println("The size of stack is "+size);
    }
    public void topelement(){
        if(top==null){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("The top element is "+top.value);
        }
    }
}