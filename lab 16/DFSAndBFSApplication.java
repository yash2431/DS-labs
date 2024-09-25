import java.util.*;

// Class to represent a graph using an adjacency list
public class DFSAndBFSApplication {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjList; // Adjacency list for each vertex

    // Constructor to initialize the graph
    @SuppressWarnings("unchecked") // Suppress unchecked cast warning
    public DFSAndBFSApplication(int vertices) {
        this.vertices = vertices;
        adjList = (LinkedList<Integer>[]) new LinkedList[vertices]; // Use generics

        // Initialize each adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>(); // Initialize each linked list
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjList[source].add(destination); // Add edge from source to destination
        adjList[destination].add(source); // For undirected graph
    }

    // Method to perform DFS traversal starting from a given vertex
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Array to keep track of visited vertices
        System.out.print("DFS Traversal starting from vertex " + startVertex + ": ");
        DFSUtil(startVertex, visited); // Recursive helper function
        System.out.println();
    }

    // Helper function for DFS (recursive)
    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true; // Mark the current vertex as visited
        System.out.print(vertex + " "); // Print the visited vertex

        // Recur for all adjacent vertices
        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited); // Recursive call
            }
        }
    }

    // Method to perform BFS traversal starting from a given vertex
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Array to keep track of visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        visited[startVertex] = true; // Mark the start vertex as visited
        queue.add(startVertex); // Add start vertex to the queue

        System.out.print("BFS Traversal starting from vertex " + startVertex + ": ");
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll(); // Dequeue the front vertex
            System.out.print(currentVertex + " "); // Print the visited vertex

            // Get all adjacent vertices of the dequeued vertex
            for (int neighbor : adjList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Mark the neighbor as visited
                    queue.add(neighbor); // Enqueue the neighbor
                }
            }
        }
        System.out.println();
    }

    // Utility function to display the adjacency list representation of the graph
    public void displayGraph() {
        System.out.println("Graph representation (Adjacency List):");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Main method to demonstrate the graph operations
    public static void main(String[] args) {
        // Create a graph with 7 vertices (0 to 6)
        DFSAndBFSApplication graph = new DFSAndBFSApplication(7);

        // Adding edges to the graph (Undirected graph)
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        // Display the adjacency list representation of the graph
        graph.displayGraph();

        // Apply DFS starting from vertex 0
        graph.DFS(0);

        // Apply BFS starting from vertex 0
        graph.BFS(0);
    }
}
