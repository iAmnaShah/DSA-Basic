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
    }
}
