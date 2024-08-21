import java.util.LinkedList;
import java.util.Queue;

class Node{
   int data;
   Node left;
   Node right;
    public Node(int data){
       this.data = data;
    }
    public Node(){}
    public void bfs(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right !=null){
                queue.add(temp.right);
            }
        }
    }

    // preorder dfs
    public void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(" "+node.data);
        preorder(node.left);
        preorder(node.right);
    }

    //inorder
    public void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(" "+node.data);
        inorder(node.right);
    }

    //postorder
    public void postorder(Node node){
        if (node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(" "+node.data);
    }
}



public class Main {
    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right = new Node(3);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        System.out.println("Breadth First Search");
       tree.bfs(tree);
        System.out.println();
        System.out.println("Preorder");
       tree.preorder(tree);
        System.out.println();
        System.out.println("Inorder");
        tree.inorder(tree);
        System.out.println();
        System.out.println("Postorder");
        tree.postorder(tree);
        System.out.println();
    }
}