import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    List<TreeNode> children;

    TreeNode(int x) {
        val = x;
        children = new ArrayList<>();
    }

    // Methods to add, get, and get size of children
    public void addChild(TreeNode child) {
        children.add(child);
    }

    public TreeNode getChild(int index) {
        if (index < 0 || index >= children.size()) {
            return null;
        }
        return children.get(index);
    }

    public int getChildrenCount() {
        return children.size();
    }
}

public class TreeIsomorphism {

    public boolean isIsomorphic(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.getChildrenCount() != root2.getChildrenCount()) {
            return false;
        }
        for (int i = 0; i < root1.getChildrenCount(); i++) {
            if (!isIsomorphic(root1.getChild(i), root2.getChild(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeIsomorphism treeIsomorphism = new TreeIsomorphism();

        // Example trees for testing
        TreeNode root1 = new TreeNode(1);
        TreeNode child1_1 = new TreeNode(2);
        TreeNode child1_2 = new TreeNode(3);
        root1.addChild(child1_1);
        root1.addChild(child1_2);

        TreeNode root2 = new TreeNode(1);
        TreeNode child2_1 = new TreeNode(2);
        TreeNode child2_2 = new TreeNode(3);
        root2.addChild(child2_1);
        root2.addChild(child2_2);

        boolean isIsomorphic = treeIsomorphism.isIsomorphic(root1, root2);
        System.out.println("Are the trees isomorphic? " + isIsomorphic);
    }
}
