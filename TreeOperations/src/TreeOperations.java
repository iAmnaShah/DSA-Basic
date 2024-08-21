class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeOperations {

    // To find and return parent of given node
    public TreeNode findParent(TreeNode root, TreeNode node) {
        if (root == null || root == node) {
            return null;
        }
        if ((root.left == node) || (root.right == node)) {
            return root;
        }
        TreeNode left = findParent(root.left, node);
        TreeNode right = findParent(root.right, node);
        return left != null ? left : right;
    }

    // To find and return depth/level of given node
    public int findDepth(TreeNode root, TreeNode node) {
        return findDepthHelper(root, node, 0);
    }

    private int findDepthHelper(TreeNode root, TreeNode node, int depth) {
        if (root == null) {
            return -1;
        }
        if (root == node) {
            return depth;
        }
        int left = findDepthHelper(root.left, node, depth + 1);
        if (left != -1) {
            return left;
        }
        return findDepthHelper(root.right, node, depth + 1);
    }

    // To find and return depth of tree
    public int findTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = findTreeDepth(root.left);
        int rightDepth = findTreeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // To find if a tree is Full or not
    public boolean isFullTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return isFullTree(root.left) && isFullTree(root.right);
        }
        return false;
    }

    // To find if two nodes are at the same level of the tree or not
    public boolean areNodesAtSameLevel(TreeNode root, TreeNode node1, TreeNode node2) {
        int depth1 = findDepth(root, node1);
        int depth2 = findDepth(root, node2);
        return depth1 == depth2;
    }

    // To find and return the total number of nodes
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // To check if two trees are equal or not (by shape)
    public boolean areTreesEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return areTreesEqual(root1.left, root2.left) && areTreesEqual(root1.right, root2.right);
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeOperations treeOps = new TreeOperations();
        TreeNode parentNode = treeOps.findParent(root, root.left.left);
        int depth = treeOps.findDepth(root, root.left.right);
        int treeDepth = treeOps.findTreeDepth(root);
        boolean isFull = treeOps.isFullTree(root);
        boolean sameLevel = treeOps.areNodesAtSameLevel(root, root.left.left, root.left.right);
        int totalNodes = treeOps.countNodes(root);

        System.out.println("Parent of given node: " + (parentNode != null ? parentNode.val : "null"));
        System.out.println("Depth of given node: " + depth);
        System.out.println("Depth of tree: " + treeDepth);
        System.out.println("Is the tree Full? " + isFull);
        System.out.println("Are nodes at the same level? " + sameLevel);
        System.out.println("Total number of nodes: " + totalNodes);

        // Creating another tree for comparison
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        boolean equalTrees = treeOps.areTreesEqual(root, root2);
        System.out.println("Are the trees equal? " + equalTrees);
    }
}
