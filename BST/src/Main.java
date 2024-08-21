import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
public class BST{
        Node root;
        BST(){
            root = null;
        }
    // Insert BST
    public void insert(int key)
    {
        root = insertRecursive(root ,key);
    }
    Node insertRecursive(Node root, int key){
            if (root == null){
                root = new Node(key);
                return root;
            }
            if(key < root.data){
                root.left = insertRecursive(root.left,key);
            } else if (key > root.data) {
                root.right = insertRecursive(root.right,key);

            }
            return  root;
    }
    void inordertraverse(Node root){
            if(root!=null){
                inordertraverse(root.left);
                System.out.print(" "+root.data);
                inordertraverse(root.right);
            }
        }
    }

    public void traverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.data);
        traverse(node.left);
        traverse(node.right);
    }

    //search
    public boolean search(Node root, int key){
        if (root == null){
            return false;
        }
        else if(key < root.data){
            search(root.left, key);
        }
        else if(key > root.data) {
            search(root.right, key);
        }
        else {
            return true;
        }

        return false;
    }


}

public class Main {
    public static void main(String[] args) {
        Node tree = new Node(50);
        tree.left = new Node(25);
        tree.left.left = new Node(10);
        tree.left.left.right = new Node(13);
        tree.right = new Node(70);
        tree.right.right = new Node(90);
        tree.right.right.left = new Node(77);
        tree.right.right.right = new Node(99);
        System.out.println("Traverse");
        tree.traverse(tree);
        System.out.println();
        System.out.println("Enter value you want to search?");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        if (tree.search(tree, key)==true){
            System.out.println("Element Found");
        }
        else
            System.out.println("Element not found");


    }
}


