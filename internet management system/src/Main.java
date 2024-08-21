import java.util.*;

class NetworkNode {
    String name;

    public NetworkNode(String name) {
        this.name = name;
    }
}

class NetworkType {
    String name;
    List<NetworkNode> nodes;

    public NetworkType(String name) {
        this.name = name;
        this.nodes = new ArrayList<>();
    }
}

class CommunicationNetwork {
    List<NetworkType> networkTypes;

    public CommunicationNetwork() {
        this.networkTypes = new ArrayList<>();
    }

    public void addNetworkType(String name) {
        networkTypes.add(new NetworkType(name));
    }

    public void addNodeToType(String typeName, String nodeName) {
        NetworkType type = findType(typeName);
        if (type != null) {
            type.nodes.add(new NetworkNode(nodeName));
        } else {
            System.out.println("Network type not found!");
        }
    }

    public void displayNetworkHierarchy() {
        for (NetworkType type : networkTypes) {
            System.out.println("Network Type: " + type.name);
            for (NetworkNode node : type.nodes) {
                System.out.println("\t- " + node.name);
            }
        }
    }

    public void removeNode(String typeName, String nodeName) {
        NetworkType type = findType(typeName);
        if (type != null) {
            NetworkNode node = findNode(nodeName, type);
            if (node != null) {
                type.nodes.remove(node);
            } else {
                System.out.println("Node not found in the network type!");
            }
        } else {
            System.out.println("Network type not found!");
        }
    }

    public NetworkNode searchNode(String nodeName) {
        for (NetworkType type : networkTypes) {
            NetworkNode node = findNode(nodeName, type);
            if (node != null) {
                return node;
            }
        }
        return null;
    }

    private NetworkType findType(String typeName) {
        for (NetworkType type : networkTypes) {
            if (type.name.equals(typeName)) {
                return type;
            }
        }
        return null;
    }

    private NetworkNode findNode(String nodeName, NetworkType type) {
        for (NetworkNode node : type.nodes) {
            if (node.name.equals(nodeName)) {
                return node;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        CommunicationNetwork cityNetwork = new CommunicationNetwork();

        // Initializing Network Types
        cityNetwork.addNetworkType("Fiber Optic");
        cityNetwork.addNetworkType("Wi-Fi");

        // Adding Nodes/Service Providers
        cityNetwork.addNodeToType("Fiber Optic", "Node 1");
        cityNetwork.addNodeToType("Fiber Optic", "Node 2");
        cityNetwork.addNodeToType("Wi-Fi", "Provider A");
        cityNetwork.addNodeToType("Wi-Fi", "Provider B");

        // Displaying Network Hierarchy
        cityNetwork.displayNetworkHierarchy();

        // Removing Node/Service Provider
        cityNetwork.removeNode("Wi-Fi", "Provider B");

        // Displaying Updated Network Hierarchy
        cityNetwork.displayNetworkHierarchy();

        // Searching for a Node/Service Provider
        NetworkNode foundNode = cityNetwork.searchNode("Node 2");
        if (foundNode != null) {
            System.out.println("Node Found: " + foundNode.name);
        } else {
            System.out.println("Node not found!");
        }
    }
}


/*
import java.util.Scanner;

public class CommunicationNetworkApp {
    public static void main(String[] args) {
        CommunicationNetwork cityNetwork = new CommunicationNetwork();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Communication Network Menu ===");
            System.out.println("1. Add Network Type");
            System.out.println("2. Add Node/Service Provider to Network Type");
            System.out.println("3. Display Network Hierarchy");
            System.out.println("4. Remove Node/Service Provider");
            System.out.println("5. Search for Node/Service Provider");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the Network Type: ");
                    String typeName = scanner.nextLine();
                    cityNetwork.addNetworkType(typeName);
                    System.out.println("Network Type added successfully.");
                    break;
                case 2:
                    System.out.print("Enter the name of the Network Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter the name of the Node/Service Provider: ");
                    String nodeName = scanner.nextLine();
                    cityNetwork.addNodeToType(type, nodeName);
                    System.out.println("Node/Service Provider added successfully.");
                    break;
                case 3:
                    System.out.println("=== Network Hierarchy ===");
                    cityNetwork.displayNetworkHierarchy();
                    break;
                case 4:
                    System.out.print("Enter the name of the Network Type: ");
                    String typeToRemove = scanner.nextLine();
                    System.out.print("Enter the name of the Node/Service Provider: ");
                    String nodeToRemove = scanner.nextLine();
                    cityNetwork.removeNode(typeToRemove, nodeToRemove);
                    System.out.println("Node/Service Provider removed successfully.");
                    break;
                case 5:
                    System.out.print("Enter the name of the Node/Service Provider to search: ");
                    String nodeToSearch = scanner.nextLine();
                    NetworkNode foundNode = cityNetwork.searchNode(nodeToSearch);
                    if (foundNode != null) {
                        System.out.println("Node/Service Provider Found: " + foundNode.name);
                    } else {
                        System.out.println("Node/Service Provider not found!");
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}

 */