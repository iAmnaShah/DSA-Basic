import java.util.*;

class Graph {
    private final int DEFAULT_SIZE = 5;
    private int N;
    private int n;
    private String[] vertexList;
    private LinkedList<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    Graph() {
        N = DEFAULT_SIZE;
        n = 0;
        vertexList = new String[N];
        adjacencyList = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    private int indexOf(String label) {
        for (int i = 0; i < n; i++) {
            if (vertexList[i].equals(label)) {
                return i;
            }
        }
        return -1;
    }

    boolean addNode(String label) {
        if (n >= N) {
            System.out.println("Graph is full, cannot add more nodes.");
            return false;
        }
        vertexList[n] = label;
        n++;
        return true;
    }

    boolean addEdge(String label1, String label2) {
        int index1 = indexOf(label1);
        int index2 = indexOf(label2);

        if (index1 == -1 || index2 == -1) {
            System.out.println("Node(s) not found in the graph.");
            return false;
        }

        adjacencyList[index1].add(indexOf(label2));
        adjacencyList[index2].add(indexOf(label1));
        return true;
    }

    boolean isNeighbour(String first, String second) {
        int index1 = indexOf(first);
        int index2 = indexOf(second);

        if (index1 == -1 || index2 == -1) {
            System.out.println("Node(s) not found in the graph.");
            return false;
        }

        return adjacencyList[index1].contains(index2) || adjacencyList[index2].contains(index1);
    }

    void bfs(String start) {
        int startIndex = indexOf(start);
        if (startIndex == -1) {
            System.out.println("Node not found in the graph.");
            return;
        }

        boolean[] visited = new boolean[N];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startIndex] = true;
        queue.add(startIndex);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(vertexList[currentNode] + " ");

            for (int neighbor : adjacencyList[currentNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    boolean isPath(String from, String to) {
        int startIndex = indexOf(from);
        int endIndex = indexOf(to);

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Node(s) not found in the graph.");
            return false;
        }

        boolean[] visited = new boolean[N];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startIndex] = true;
        queue.add(startIndex);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == endIndex) {
                return true;
            }

            for (int neighbor : adjacencyList[currentNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    int lengthOfPath(String first, String second) {
        int startIndex = indexOf(first);
        int endIndex = indexOf(second);

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Node(s) not found in the graph.");
            return -1;
        }

        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startIndex] = true;
        queue.add(startIndex);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int neighbor : adjacencyList[currentNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[currentNode] + 1;
                    queue.add(neighbor);

                    if (neighbor == endIndex) {
                        return distance[endIndex];
                    }
                }
            }
        }
        return -1;
    }

    int degreeOfVertex(String label) {
        int index = indexOf(label);

        if (index == -1) {
            System.out.println("Node not found in the graph.");
            return -1;
        }

        return adjacencyList[index].size();
    }

    boolean isSource(String label) {
        int index = indexOf(label);

        if (index == -1) {
            System.out.println("Node not found in the graph.");
            return false;
        }

        return adjacencyList[index].isEmpty();
    }

    boolean isSink(String label) {
        int index = indexOf(label);

        if (index == -1) {
            System.out.println("Node not found in the graph.");
            return false;
        }

        return adjacencyList[index].size() == 0;
    }

    void displayGraph() {
        for (int i = 0; i < n; i++) {
            System.out.print(vertexList[i] + " -> ");
            for (int node : adjacencyList[i]) {
                System.out.print(vertexList[node] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        // Adding edges
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");

        // Displaying the graph
        graph.displayGraph();

        // Additional operations
        System.out.println("Is B a neighbor of A? " + graph.isNeighbour("A", "B"));
        System.out.print("BFS traversal starting from A: ");
        graph.bfs("A");

        System.out.println("Is there a path from A to E? " + graph.isPath("A", "E"));
        System.out.println("Length of path from A to E: " + graph.lengthOfPath("A", "E"));

        System.out.println("Degree of vertex B: " + graph.degreeOfVertex("B"));
        System.out.println("Is A a source node? " + graph.isSource("A"));
        System.out.println("Is E a sink node? " + graph.isSink("E"));
    }
}
