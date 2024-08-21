import java.util.ArrayList;
import java.util.List;

class Node {
    String name;
    List<Node> children;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
}

class InventoryManager {
    Node root;

    public InventoryManager() {
        root = new Node("Inventory");
    }

    public void addBookToInventory(String category, String bookTitle) {
        Node categoryNode = findCategory(root, category);
        if (categoryNode != null) {
            categoryNode.children.add(new Node(bookTitle));
        } else {
            Node newCategory = new Node(category);
            newCategory.children.add(new Node(bookTitle));
            root.children.add(newCategory);
        }
    }

    private Node findCategory(Node node, String category) {
        if (node.name.equals(category)) {
            return node;
        }
        for (Node child : node.children) {
            Node found = findCategory(child, category);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public void displayInventory() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) return;

        System.out.println("\t".repeat(Math.max(0, level)) + node.name);
        for (Node child : node.children) {
            display(child, level + 1);
        }
    }

    public void removeBookOrCategory(String item) {
        remove(root, item);
    }

    private void remove(Node node, String item) {
        if (node == null) return;

        for (Node child : node.children) {
            if (child.name.equals(item)) {
                node.children.remove(child);
                return;
            }
            remove(child, item);
        }
    }

    public void searchBookOrAuthor(String item) {
        search(root, item);
    }

    private void search(Node node, String item) {
        if (node == null) return;

        if (node.name.equals(item)) {
            System.out.println("Item found: " + node.name);
            return;
        }

        for (Node child : node.children) {
            search(child, item);
        }
    }

    // Other operations (UpdateInventory, etc.) can be added here.
}

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addBookToInventory("Fantasy", "Harry Potter");
        inventoryManager.addBookToInventory("Science Fiction", "Foundation");
        inventoryManager.addBookToInventory("Fantasy", "Lord of the Rings");

        System.out.println("Displaying Inventory:");
        inventoryManager.displayInventory();

        System.out.println("\nRemoving 'Foundation' book:");
        inventoryManager.removeBookOrCategory("Foundation");
        inventoryManager.displayInventory();

        System.out.println("\nSearching for 'Harry Potter':");
        inventoryManager.searchBookOrAuthor("Harry Potter");
    }
}
