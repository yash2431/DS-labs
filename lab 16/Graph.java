import java.util.*;

// Class to represent a graph using adjacency list
public class Graph {
    private Map<Integer, List<Integer>> adjList; // Adjacency list

    // Constructor to initialize the adjacency list
    public Graph() {
        adjList = new HashMap<>();
    }

    // Add an edge to the graph (undirected graph assumed here)
    public void addEdge(int source, int destination) {
        adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source); // For undirected graph
    }

    // Function to perform DFS
    public void DFS(int start) {
        Set<Integer> visited = new HashSet<>(); // To keep track of visited nodes
        System.out.print("DFS Traversal: ");
        DFSRecursive(start, visited);
        System.out.println();
    }

    // Helper function for DFS (recursive implementation)
    private void DFSRecursive(int vertex, Set<Integer> visited) {
        visited.add(vertex); // Mark the current node as visited
        System.out.print(vertex + " "); // Print the node

        // Recur for all the vertices adjacent to the current vertex
        for (int neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                DFSRecursive(neighbor, visited);
            }
        }
    }

    // Function to perform BFS
    public void BFS(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Dequeue a vertex
            System.out.print(vertex + " ");

            // Get all the neighbors of the dequeued vertex
            for (int neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor); // Enqueue the adjacent nodes
                }
            }
        }
        System.out.println();
    }

    // Function to display the graph as adjacency list
    public void printGraph() {
        System.out.println("Graph adjacency list:");
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding edges to the graph (example graph)
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        // Print the graph
        graph.printGraph();

        // Perform DFS from node 0
        graph.DFS(0);

        // Perform BFS from node 0
        graph.BFS(0);
    }
}
