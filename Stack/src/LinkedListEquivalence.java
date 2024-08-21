class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListEquivalence {
    public static boolean areEquivalent(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false; // Data doesn't match, the lists are not equivalent.
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        // Check if both lists reached the end at the same time.
        return head1 == null && head2 == null;
    }

    public static void main(String[] args) {
        // Create the first linked list: 1 -> 2 -> 3
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        // Create the second linked list: 1 -> 2 -> 3
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);

        boolean result = areEquivalent(list1, list2);

        if (result) {
            System.out.println("The two linked lists are equivalent.");
        } else {
            System.out.println("The two linked lists are not equivalent.");
        }
    }
}
