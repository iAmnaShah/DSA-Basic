class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class EulerTourTraversal {
    static int preorder = 1;

    static int eulerTour(TreeNode root, int[] preorderArray, int[] inorderArray, int[] postorderArray,
                         int[] ancestorsCount, int[] descendantsCount) {
        if (root == null) {
            return 0;
        }

        // Preorder Labeling
        preorderArray[root.data - 1] = preorder++;

        // Counting Descendants
        int leftDescendants = eulerTour(root.left, preorderArray, inorderArray, postorderArray,
                ancestorsCount, descendantsCount);
        int rightDescendants = eulerTour(root.right, preorderArray, inorderArray, postorderArray,
                ancestorsCount, descendantsCount);
        descendantsCount[root.data - 1] = leftDescendants + rightDescendants;

        // Inorder Labeling
        inorderArray[root.data - 1] = preorder++;

        // Ancestor Counts
        ancestorsCount[root.data - 1] = leftDescendants;

        // Postorder Labeling
        postorderArray[root.data - 1] = preorder++;

        return descendantsCount[root.data - 1] + 1;
    }

    static void visualizeEulerTour(TreeNode root) {
        int nodesCount = countNodes(root);
        int[] preorderArray = new int[nodesCount];
        int[] inorderArray = new int[nodesCount];
        int[] postorderArray = new int[nodesCount];
        int[] ancestorsCount = new int[nodesCount];
        int[] descendantsCount = new int[nodesCount];

        eulerTour(root, preorderArray, inorderArray, postorderArray, ancestorsCount, descendantsCount);

        System.out.println("Node\tPreorder\tInorder\t\tPostorder\tAncestors\tDescendants");
        for (int i = 0; i < nodesCount; i++) {
            System.out.println((i + 1) + "\t\t" + preorderArray[i] + "\t\t" + inorderArray[i] + "\t\t" +
                    postorderArray[i] + "\t\t" + ancestorsCount[i] + "\t\t" + descendantsCount[i]);
        }
    }

    static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Euler Tour Traversal Information:");
        visualizeEulerTour(root);
    }
}
