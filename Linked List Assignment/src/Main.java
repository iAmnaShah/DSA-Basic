public class Main {
    public static void main(String[] args) {
     /*   node node1 = new node();
        node1.data = 70;
        node node2 = new node();
        node2.data = 56;
        node node3 = new node();
        node3.data = 77;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

      */
        node head = null;

        for(int i=0; i<5; i++) {
            node n = new node(i);
            if (head == null)
                head = n;
            else {
                node current = head;
                while (current.next != null)
                    current = current.next;
                current.next = n;
            }
        }
        node current = head;
        while (current!=null)
        {
            System.out.println(current.data+"->");
            current= current.next;
        }
        System.out.println("null");

    }
}
class Node{
    int data;
    node next;
    void node(int data){
      this.data = data;
      this.next = next;
    }

}