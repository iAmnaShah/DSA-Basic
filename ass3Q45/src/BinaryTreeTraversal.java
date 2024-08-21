class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeTraversal {

    // preorderNext: Return the position visited after p in a preorder traversal of T
    public TreeNode preorderNext(TreeNode p) {
        if (p == null) {
            return null;
        }

        // If p has a left child, return the left child
        if (p.left != null) {
            return p.left;
        }

        // If p has a right child, return the right child
        if (p.right != null) {
            return p.right;
        }

        // Traverse up the tree until finding a node that has a right sibling or ancestor with a right child
        while (p.parent != null) {
            if (p == p.parent.left && p.parent.right != null) {
                return p.parent.right;
            }
            p = p.parent;
        }

        return null; // p is the last node visited
    }

    // inorderNext: Return the position visited after p in an inorder traversal of T
    public TreeNode inorderNext(TreeNode p) {
        if (p == null) {
            return null;
        }

        // If p has a right child, return the leftmost node in the right subtree
        if (p.right != null) {
            TreeNode current = p.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }

        // Traverse up the tree until finding a node that is the left child of its parent
        while (p.parent != null && p == p.parent.right) {
            p = p.parent;
        }

        return p.parent; // p is the last node visited or the parent of p
    }

    // postorderNext: Return the position visited after p in a postorder traversal of T
    public TreeNode postorderNext(TreeNode p) {
        if (p == null) {
            return null;
        }

        // If p is the root, it is the last node visited
        if (p.parent == null) {
            return null;
        }

        // If p is the left child of its parent and the parent has a right child, traverse to the right subtree
        if (p == p.parent.left && p.parent.right != null) {
            TreeNode current = p.parent.right;
            while (current.left != null || current.right != null) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return current;
        }

        return p.parent; // Traverse up the tree
    }
}
