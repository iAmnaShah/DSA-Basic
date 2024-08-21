import java.util.*;

class TreeNode {
    int val;
    List<TreeNode> children;

    TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class TreeConverter {

    public static TreeNode convertTree(TreeNode root, int p) {
        if (root == null || root.val == p) {
            return root;
        }

        for (TreeNode child : root.children) {
            TreeNode newRoot = convertTree(child, p);
            if (newRoot != null) {
                root.children.remove(child);
                newRoot.children.add(root);
                return newRoot;
            }
        }

        return null;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " -> ");
        for (TreeNode child : root.children) {
            System.out.print(child.val + " ");
        }
        System.out.println();

        for (TreeNode child : root.children) {
            printTree(child);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);
        node3.children.add(node6);

        System.out.println("Original Tree:");
        printTree(root);

        int positionToRoot = 5; // Change this to the desired position to become the new root

        TreeNode newRoot = convertTree(root, positionToRoot);

        System.out.println("\nTree with position " + positionToRoot + " as new root:");
        printTree(newRoot);
    }
}
