// Node class for a basic linked list
class ListNode {
    TNode value;
    ListNode next;

    // Parametrized constructor
    public ListNode(TNode v) {
        value = v;
        next = null;
    }

    // Default constructor
    public ListNode() {
        value = null;
        next = null;
    }
}

// LinkedList class
class LinkedList {
    ListNode head;

    // Public method to add a node to the linked list
    public void addNode(TNode v) {
        ListNode newNode = new ListNode(v);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Public method to print the linked list
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Node class for BST
class TNode {
    int value;
    TNode left;
    TNode right;

    // Parametrized constructor
    public TNode(int v) {
        value = v;
        left = null;
        right = null;
    }

    // Default constructor
    public TNode() {
        value = 0;
        left = null;
        right = null;
    }
}

// BST class
class BST {
    TNode root;

    // Public method to insert a node into the BST
    public boolean insertNode(int v) {
        TNode nNode = new TNode(v);
        root = recursiveInsertNode(root, nNode);
        return true;
    }

    // Private method for recursive insertion
    private TNode recursiveInsertNode(TNode node, TNode nNode) {
        if (node == null) {
            return nNode;
        }

        if (nNode.value < node.value) {
            node.left = recursiveInsertNode(node.left, nNode);
        } else if (nNode.value > node.value) {
            node.right = recursiveInsertNode(node.right, nNode);
        }

        return node;
    }

    // Public method to search for a node in the BST
    public TNode search(int v) {
        return recursiveSearch(root, v);
    }

    // Private method for recursive search
    private TNode recursiveSearch(TNode node, int v) {
        if (node == null || node.value == v) {
            return node;
        }

        if (v < node.value) {
            return recursiveSearch(node.left, v);
        } else {
            return recursiveSearch(node.right, v);
        }
    }

    // Public method for Depth-First Search (In-order traversal)
    public void DFS() {
        DFS(root);
    }

    // Private method for in-order traversal
    private void DFS(TNode node) {
        if (node != null) {
            DFS(node.left);
            System.out.print(node.value + " ");
            DFS(node.right);
        }
    }

    // Public method for Breadth-First Search using the custom LinkedList
    public void BFS() {
        BFS(root);
    }

    // Private method for iterative Breadth-First Search without using Queue interface
    private void BFS(TNode node) {
        if (node == null) {
            return;
        }

        LinkedList linkedList = new LinkedList();
        linkedList.addNode(node);

        while (linkedList.head != null) {
            TNode current = (TNode) linkedList.head.value;
            linkedList.head = linkedList.head.next;

            System.out.print(current.value + " ");

            if (current.left != null) {
                linkedList.addNode(current.left);
            }

            if (current.right != null) {
                linkedList.addNode(current.right);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        // Insert nodes
        bst.insertNode(250);
        bst.insertNode(340);
        bst.insertNode(790);
        bst.insertNode(20);
        bst.insertNode(404);
        bst.insertNode(603);
        bst.insertNode(800);

        // Search for a node
        TNode searchedNode = bst.search(404);
        System.out.println("Search Result: " + (searchedNode != null ? searchedNode.value : "Not found"));

        // Depth-First Search (In-order traversal)
        System.out.println("DFS: ");
        bst.DFS();
        System.out.println();

        // Breadth-First Search using the custom LinkedList
        System.out.println("BFS: ");
        bst.BFS();
    }
}