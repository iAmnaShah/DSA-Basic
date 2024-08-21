class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeTraversalOrder {

    public boolean arePreorderAndPostorderSame(TreeNode root) {
        // Create strings to store the sequences of traversals
        StringBuilder preorder = new StringBuilder();
        StringBuilder postorder = new StringBuilder();

        // Perform preorder and postorder traversals
        preorderTraversal(root, preorder);
        postorderTraversal(root, postorder);

        // Compare the sequences
        return preorder.toString().equals(postorder.toString());
    }

    // Preorder traversal
    private void preorderTraversal(TreeNode node, StringBuilder sequence) {
        if (node != null) {
            sequence.append(node.val).append(" ");
            preorderTraversal(node.left, sequence);
            preorderTraversal(node.right, sequence);
        }
    }

    // Postorder traversal
    private void postorderTraversal(TreeNode node, StringBuilder sequence) {
        if (node != null) {
            postorderTraversal(node.left, sequence);
            postorderTraversal(node.right, sequence);
            sequence.append(node.val).append(" ");
        }
    }

    public static void main(String[] args) {
        TreeTraversalOrder treeOrder = new TreeTraversalOrder();

        // Creating a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        boolean sameOrder = treeOrder.arePreorderAndPostorderSame(root);
        System.out.println("Are the preorder and postorder same? " + sameOrder);
    }
}
